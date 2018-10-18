package com.ljt.newmvvm.util.log

import com.orhanobut.logger.Logger
import timber.log.Timber
import com.orhanobut.logger.AndroidLogAdapter



class DebugTree : Timber.Tree(){

    init {
        Logger.addLogAdapter(AndroidLogAdapter())
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        Logger.log(priority,tag,message,t)
    }

}