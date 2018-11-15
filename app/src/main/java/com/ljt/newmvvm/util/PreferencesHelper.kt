package com.ljt.newmvvm.util

import android.preference.PreferenceManager
import com.ljt.newmvvm.MainApplication

object PreferencesHelper {

    private val FIRST_START = "FIRST_START"
    private val preferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.getInstance())

    //是否第一次启动App
    var isFirstStart = preferences.getBoolean(FIRST_START,true)
    set(value) = preferences.edit().putBoolean(FIRST_START,value).apply()


}