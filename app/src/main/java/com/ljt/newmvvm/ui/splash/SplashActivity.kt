package com.ljt.newmvvm.ui.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ljt.newmvvm.MainActivity
import com.ljt.newmvvm.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.theme_splash_layout)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        Observable.timer(2,TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    startActivity(Intent(this@SplashActivity,MainActivity::class.java))
                    finish()
                }
    }
}
