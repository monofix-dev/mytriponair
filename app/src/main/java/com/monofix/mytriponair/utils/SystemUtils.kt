package com.monofix.mytriponair.utils

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.Log
import com.monofix.mytriponair.BuildConfig
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.pow
import kotlin.math.sqrt

class SystemUtils {

    companion object {

        fun getScreenWidth(): Int = Resources.getSystem().displayMetrics.widthPixels
        fun getScreenHeight(): Int = Resources.getSystem().displayMetrics.heightPixels
        fun getAppVersionName(): String = BuildConfig.VERSION_NAME
        fun getAppVersionCode(): Int = BuildConfig.VERSION_CODE
        fun getDeviceCountryCode(): String = Locale.getDefault().country
        fun getDeviceLanguageCode(): String = Locale.getDefault().toString()
        fun getDeviceDpi(): Int = Resources.getSystem().displayMetrics.densityDpi
        fun dpToPixels(c: Context, dp: Int): Int = (c.resources.displayMetrics.density * dp).toInt()
        fun pixelsToDp(c: Context, pixel: Int): Int = (pixel.toFloat() / c.resources.displayMetrics.density).toInt()

        fun getCurrentTimezoneOffset(): String {
            val mCalendar = GregorianCalendar()
            val mTimeZone = mCalendar.timeZone
            val mGMTOffset = -mTimeZone.rawOffset

            return TimeUnit.MINUTES.convert(mGMTOffset.toLong(), TimeUnit.MILLISECONDS).toString()
        }

        fun getDeviceLocale(context: Context): Locale {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                context.resources.configuration.locales.get(0)
            } else {
                context.resources.configuration.locale
            }
        }

        fun getRandomCode(length: Int): String {
            val rnd = Random()
            val buf = StringBuffer()

            for (i in 0 until length) {
                if (rnd.nextBoolean()) {
                    buf.append((rnd.nextInt(26) + 97).toChar())
                } else {
                    buf.append(rnd.nextInt(10))
                }
            }

            return buf.toString()
        }

        fun getDeviceInch(): Double {
            val dm = Resources.getSystem().displayMetrics

            val density = dm.density * 160
            val x = (dm.widthPixels / density).toDouble().pow(2.0)
            val y = (dm.heightPixels / density).toDouble().pow(2.0)
            Log.d("inches: {}", sqrt(x + y).toString())
            return sqrt(x + y)
        }

        fun displayCount(count: Int): String {
            var countStr = ""
            countStr = when {
                count >= 1000000000 -> {
                    "%.1fb".format(count.toFloat() / 1000000000)
                }
                count >= 1000000 -> {
                    "%.1fm".format(count.toFloat() / 1000000)
                }
                count >= 1000 -> {
                    "%.1fk".format(count.toFloat() / 1000)
                }
                else -> {
                    "$count"
                }
            }
            if (countStr.contains(".0")) {
                countStr = countStr.replace(".0", "")
            }

            return countStr
        }
    }
}