package com.monofix.mytriponair.utils

import android.content.Context
import com.monofix.mytriponair.application.MyTripOnAirApplication

object PreferencesUtils {

    private const val NAME = "MyTripOnAir"

    fun saveInt(key: String, value: Int) {
        val pref = MyTripOnAirApplication.instance.applicationContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        val edit = pref.edit()
        edit.putInt(key, value)
        edit.apply()
    }

    fun saveString(key: String, value: String) {
        val pref = MyTripOnAirApplication.instance.applicationContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        val edit = pref.edit()
        edit.putString(key, value)
        edit.apply()
    }

    fun saveBoolean(key: String, value: Boolean) {
        val pref = MyTripOnAirApplication.instance.applicationContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        val edit = pref.edit()
        edit.putBoolean(key, value)
        edit.apply()
    }

    fun saveLong(key: String, value: Long) {
        val pref = MyTripOnAirApplication.instance.applicationContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        val edit = pref.edit()
        edit.putString(key, value.toString())
        edit.apply()
    }

    fun loadInt(key: String, defaultValue: Int): Int {
        val pref = MyTripOnAirApplication.instance.applicationContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        return pref.getInt(key, defaultValue)
    }

    fun loadString(key: String, defaultValue: String): String {
        val pref = MyTripOnAirApplication.instance.applicationContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        return pref.getString(key, defaultValue) ?: ""
    }


    fun loadBoolean(key: String, defaultValue: Boolean): Boolean {
        val pref = MyTripOnAirApplication.instance.applicationContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        return pref.getBoolean(key, defaultValue)
    }

    fun loadLong(key: String, defaultValue: Long): Long {
        val pref = MyTripOnAirApplication.instance.applicationContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        val value = pref.getString(key, defaultValue.toString())
        return java.lang.Long.parseLong(value!!)
    }

}