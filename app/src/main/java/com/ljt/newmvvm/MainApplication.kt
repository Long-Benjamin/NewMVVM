package com.ljt.newmvvm

import com.alibaba.android.arouter.launcher.ARouter
import com.ljt.newmvvm.base.ui.BaseApplication
import com.ljt.newmvvm.dagger.AppComponent
import com.ljt.newmvvm.dagger.AppModule
import com.ljt.newmvvm.dagger.DaggerAppComponent
import com.ljt.newmvvm.util.log.DebugTree
import com.ljt.newmvvm.util.log.ReleaseTree
import timber.log.Timber
import javax.inject.Singleton
import kotlin.concurrent.thread

/**
 * 【主程序入口】为了提升实际的启动速度：
 *  1、尽可能将组件的初始化放到子线程中
 *  2、将必要的组件放在主线程中优先初始化
 */
class MainApplication : BaseApplication() {

    companion object {
        private lateinit var INSTANCE: MainApplication

        @JvmStatic fun getInstance()  = INSTANCE

    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        DaggerAppComponent.builder().appModule(AppModule(this)).build().inject(this)

        thread(start = true){
            initComponent()
        }

        //子线程中初始化Timber，所以这个日志没有被输出
        Timber.e("000000000000111111= APP启动")

    }

    private fun initComponent() {

        //日志打印初始化
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }

        //阿里路由初始化
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()            // 打印日志
            ARouter.openDebug()         // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)


    }
}
