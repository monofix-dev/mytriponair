package com.monofix.mytriponair.utils

import android.os.CountDownTimer
import android.os.Process
import android.util.Log
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.monofix.mytriponair.BuildConfig
import com.monofix.mytriponair.MainActivity
import com.monofix.mytriponair.R
import com.monofix.mytriponair.extension.openNewTabWindow
import com.monofix.mytriponair.extension.showEventPopup
import com.monofix.mytriponair.extension.showOneButtonDialog
import kotlinx.android.synthetic.main.activity_main.*

const val REMOTE_CONFIG_TAG = "Remote Config"

private var remoteConfig: FirebaseRemoteConfig? = null

fun MainActivity.initRemoteConfig() {
    if (BuildConfig.DEBUG) {
        Log.d(REMOTE_CONFIG_TAG, "Debug")
    } else {
        Log.d(REMOTE_CONFIG_TAG, "Release")
    }

    remoteConfig = FirebaseRemoteConfig.getInstance()
    val configSettings = FirebaseRemoteConfigSettings.Builder()
        .setMinimumFetchIntervalInSeconds(if (BuildConfig.DEBUG) 0 else 3600)
        .build()
    remoteConfig!!.setConfigSettingsAsync(configSettings)  //You missed this line
    remoteConfig!!.setDefaultsAsync(R.xml.remote_config_defaults)


    // Remote Config Update
    remoteConfig!!.fetchAndActivate().addOnCompleteListener(this) { task ->
        // 통신 성공
        if (task.isSuccessful) {
            // 업데이트 완료
            if (task.result) {
                // 최소 버전 업데이트인지 체크
                if (isMinVersionUpdate()) {
                    // 업데이트 팝업
                    showMinVersionUpdatePopup()
                }
                else {
                    // 이벤트 팝업
                    if(!isLaunchByPushMessage){
                        checkEventPopup()
                    }
                }
            }
            // 업데이트 되지 않음
            else {
                // 이벤트 팝업
                if(!isLaunchByPushMessage) {
                    checkEventPopup()
                }
            }
        }
        // 통신 실패
        else {
            Log.d("Remote Config", "Fetch failed")
        }
    }
}

// Event Popup
fun MainActivity.checkEventPopup() {
    val eventName = remoteConfig?.getString("event_name")
    val eventCode = remoteConfig?.getString("event_code")
    val eventImageURL = remoteConfig?.getString("event_image_url")
    val eventClickLink = remoteConfig?.getString("event_click_link")
    val eventImgWidth = remoteConfig?.getDouble("event_image_width")?.toInt() ?: 1
    val eventImgHeight = remoteConfig?.getDouble("event_image_height")?.toInt() ?: 1

    if (!eventImageURL.isNullOrEmpty()) {
        if (getCurrentDate() != PreferencesUtils.loadString(EVENT_KEY_DATE_TODAY, "")) {
            showEventPopup(this, eventImageURL, eventImgWidth, eventImgHeight,
                actionEvent = {

                    if (!eventClickLink.isNullOrEmpty()) {
                        webMain.loadUrl(eventClickLink)
                    }
                    it.dismiss()
                },
                actionClose = {
                    it.dismiss()
                },
                actionCloseToday = {
                    PreferencesUtils.saveString(EVENT_KEY_DATE_TODAY, getCurrentDate())
                    it.dismiss()
                }
            )
        }
    }
}

// App version check
fun MainActivity.showMinVersionUpdatePopup() {
    showOneButtonDialog(this,
        getString(R.string.dialog_min_version_title),
        getString(R.string.dialog_min_version_desc),
        getString(R.string.dialog_min_version_confirm),
        false,
        confirmListener = {
            openNewTabWindow(this, remoteConfig?.getString("android_store_url"))

            val timer = object: CountDownTimer(300, 300) {
                override fun onTick(millisUntilFinished: Long) {}
                override fun onFinish() {moveTaskToBack(true)
                    finish()
                    Process.killProcess(Process.myPid())}
            }
            timer.start()
        })
}


fun MainActivity.isMinVersionUpdate(): Boolean {
    val appVersionCode = BuildConfig.VERSION_CODE
    val minCode = remoteConfig?.getDouble("android_min_code")?.toInt() ?: 0
    val currentCode = remoteConfig?.getString("android_current_code")
    val versionName = remoteConfig?.getString("android_version_name")
    val storeURL = remoteConfig?.getString("android_store_url")

    return minCode > appVersionCode
}


