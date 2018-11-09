package com.ljt.newmvvm.util.log

import com.orhanobut.logger.Logger
import timber.log.Timber
import com.orhanobut.logger.AndroidLogAdapter


/**
 * 正式打包后不再打印日志
 */
class ReleaseTree : Timber.Tree(){

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
    }

    override fun isLoggable(tag: String?, priority: Int): Boolean {
        return false
    }

}