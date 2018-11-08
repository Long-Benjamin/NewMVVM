package com.ljt.newmvvm.base.ui

import android.app.Activity
import android.app.Application
import android.os.Bundle

open class BaseApplication: Application(){

    companion object {
        private lateinit var application: Application
        private fun setApplication(baseApplication: BaseApplication) {
            application = baseApplication
            application.registerActivityLifecycleCallbacks(object: ActivityLifecycleCallbacks{

                override fun onActivityPaused(activity: Activity) {
                }

                override fun onActivityResumed(activity: Activity) {
                }

                override fun onActivityStarted(activity: Activity) {
                }

                override fun onActivityDestroyed(activity: Activity) {
                    AppManager.instance.removeActivity(activity)
                }

                override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {
                }

                override fun onActivityStopped(activity: Activity) {
                }

                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                    AppManager.instance.addActivity(activity)
                }

            })

        }

        fun getInstance(): Application{
            if (application == null){
                throw NullPointerException("Please inherit BaseApplication or call setApplication.")
            }
            return application
        }
    }

    override fun onCreate() {
        super.onCreate()
        setApplication(this)
    }

}