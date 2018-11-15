package com.ljt.newmvvm.ui.splash

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.ljt.newmvvm.ui.home.MainActivity
import com.ljt.newmvvm.R
import com.ljt.newmvvm.ui.splash.viewmodel.SplashModel
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * 【闪屏页面】
 *  1.视觉上的开始启动
 *  2.不突兀的页面切换
 *  3.延时跳转代码移到ViewModel
 */
class SplashActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //替换原来的透明背景样式
        setTheme(R.style.theme_splash_layout)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        val viewModel = ViewModelProviders.of(this).get(SplashModel::class.java)

        val isFirstObserver = Observer<Boolean>{
            if (it!!){
                Toast.makeText(this,"第一次启动App！",Toast.LENGTH_SHORT).show()
            }
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
            this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        viewModel.IS_FIRST_START.observe(this, isFirstObserver)

        viewModel.toNext()//正式调用延时跳转
    }

}
