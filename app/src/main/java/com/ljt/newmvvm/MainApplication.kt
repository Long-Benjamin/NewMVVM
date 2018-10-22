package com.ljt.newmvvm

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.ljt.newmvvm.base.http.entity.DataBean
import com.ljt.newmvvm.util.log.DebugTree
import com.ljt.newmvvm.util.log.ReleaseTree

import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initComponent()

    }

    private fun initComponent() {
        //阿里路由初始化
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)

        //日志打印初始化
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }


    }
}
