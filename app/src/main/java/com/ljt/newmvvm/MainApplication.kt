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

//@Singleton
class MainApplication : BaseApplication() {

    companion object {
        private lateinit var INSTANCE: MainApplication

        @JvmStatic fun getInstance() = INSTANCE
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this


        DaggerAppComponent.builder().appModule(AppModule(this)).build().inject(this)

        //为了启动速度，将部分初始化放置到子线程中
        thread(start = true){
            initComponent()
        }

        //只有上面线程中的初始化完成后，这个Timber 才能真正的打印日志
        Timber.e("000000000000111111= APP启动")

    }

    private fun initComponent() {
        
        //阿里路由初始化
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()            // 打印日志
            ARouter.openDebug()         // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
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
