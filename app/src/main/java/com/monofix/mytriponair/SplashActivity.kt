package com.monofix.mytriponair

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.Settings
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.monofix.mytriponair.extension.showTwoButtonDialog
import kotlin.system.exitProcess

const val MY_PERMISSION_REQUEST_LOCATION = 0
private const val KEY_FIRST_INIT = "KEY_FIRST_INIT"

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_splash)

        // 권한 체크
        permissionCheck()
    }

    private fun permissionCheck() {
        // 권한 승낙 상태면 메인으로 이동
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            loadMain()
        }
        // 권한 거절 상태인 경우 팝업 띄우기
        else {
            // 처음 진입인 경우
            if (getFirstInit()) {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), MY_PERMISSION_REQUEST_LOCATION)
            }
            // 나중에 진입을 하는 경우
            else {
                showTwoButtonDialog(this@SplashActivity, getString(R.string.dialog_location_title), getString(R.string.dialog_location_message),
                    getString(R.string.dialog_location_confirm), getString(R.string.dialog_location_cancel),
                    confirmListener = {
                        val intent = Intent()
                        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                        intent.data = Uri.fromParts("package", packageName, null)
                        startActivity(intent)
                        finishApp()
                    },
                    cancelListener = {
                        finishApp()
                    })
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String?>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSION_REQUEST_LOCATION) {
            // 수락 시
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadMain()
            }

            // 거절 시
            if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                // 처음 진입인 경우: 다시 권한 요청
                if (getFirstInit()) {
                    setFirstInit()
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), MY_PERMISSION_REQUEST_LOCATION)
                }
                // 2번 이상 문의를 한 경우 앱 종료
                else {
                    finishApp()
                }
            }
        }
    }

    private fun loadMain() {
        object : CountDownTimer(200, 200) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        }.start()
    }

    private fun finishApp() {
        ActivityCompat.finishAffinity(this)
        exitProcess(0)
    }


    private fun setFirstInit() {
        val pref = getSharedPreferences(KEY_FIRST_INIT, Context.MODE_PRIVATE)
        val edit = pref.edit()
        edit.putBoolean(KEY_FIRST_INIT, false)
        edit.apply()
    }

    private fun getFirstInit(): Boolean {
        val pref = getSharedPreferences(KEY_FIRST_INIT, Context.MODE_PRIVATE)
        return pref.getBoolean(KEY_FIRST_INIT, true)
    }
}