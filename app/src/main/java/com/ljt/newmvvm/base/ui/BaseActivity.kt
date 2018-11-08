package com.ljt.newmvvm.base.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

abstract class BaseActivity<Binding : ViewDataBinding>: RxAppCompatActivity() {

    private lateinit var activityBinding: Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        doBeforCreate()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initParam()
        activityBinding = DataBindingUtil.setContentView(this, getLayoutId())

    }

    /**
     * 获取上层传过来的数据
     */
    private fun initParam() {

    }

    /**
     * 比如做Theme 的修改之类的
     */
    fun doBeforCreate() {

    }

    /** 获取布局文件ID*/
    abstract fun getLayoutId(): Int

    /** 获取binding对象*/
    fun getBinding() : Binding = activityBinding

}