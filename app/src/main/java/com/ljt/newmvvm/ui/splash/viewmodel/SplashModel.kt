package com.ljt.newmvvm.ui.splash.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ljt.newmvvm.util.PreferencesHelper
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashModel : ViewModel(){

    var IS_FIRST_START = MutableLiveData<Boolean>()


    fun isFirstStart() = PreferencesHelper.isFirstStart

    fun setIsFirstStart(isFirst : Boolean){
        PreferencesHelper.isFirstStart = isFirst
    }

    /**
     * 业务逻辑代码转移到这里,【不需要担心内存泄漏，MutableLiveData有生命周期感知】
     */
    fun toNext(){
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    IS_FIRST_START.value = isFirstStart()
                    if (isFirstStart()){
                        setIsFirstStart(false)
                    }

                }
    }

}