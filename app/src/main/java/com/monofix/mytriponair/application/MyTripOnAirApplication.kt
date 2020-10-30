package com.monofix.mytriponair.application

import android.app.Application
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId

class MyTripOnAirApplication: Application() {

    private val TAG = "MyTripOnAirApplication"

    companion object {
        lateinit var instance: MyTripOnAirApplication
            private set

        // 배포시
        // releaseMode: true, releaseServer: true, isDebug: false, isAPIDebug: false
        const val releaseMode: Boolean = true // true: 마켓 업로드 시 사용되는 버전, false: 개발 기간 때 사용되는 버전
        const val releaseServer: Boolean = true // true: 실서버, false: 개발서버
        const val isDebug: Boolean = false // true: show Log, false: hide Log
        const val isAPIDebug: Boolean = false // true: show Log, false: hide Log
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        // Firebase
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                // Log and toast
                val msg = "InstanceID Token: $token"
                Log.d(TAG, msg)
            })


        try {
            val token = FirebaseInstanceId.getInstance().token
            Log.d("IDService", "device token : $token")
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }
}
