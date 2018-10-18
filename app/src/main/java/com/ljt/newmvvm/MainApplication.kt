package com.ljt.newmvvm

import android.app.Application
import com.ljt.newmvvm.util.log.DebugTree
import com.ljt.newmvvm.util.log.ReleaseTree

import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }
}
