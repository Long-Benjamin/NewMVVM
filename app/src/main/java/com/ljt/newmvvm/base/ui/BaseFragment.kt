package com.ljt.newmvvm.base.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import timber.log.Timber

abstract class BaseFragment<Binding: ViewDataBinding> : Fragment() {

    private lateinit var fragmentBinding : Binding
    val TAG = this.javaClass.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.e("$TAG ------------------> onCreate()")
        initParam()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    abstract fun initView()
    //获取跳转参数
    abstract fun initParam()

    fun getBinding() : Binding = fragmentBinding

    /** 获取布局文件ID*/
    abstract fun getLayoutId(): Int

    override fun onStart() {
        super.onStart()
        Timber.e("$TAG ------------------> onStart()")
    }

    override fun onResume() {
        super.onResume()
        Timber.e("$TAG ------------------> onResume()")
    }

    override fun onPause() {
        super.onPause()
        Timber.e("$TAG ------------------> onPause()")
    }

    override fun onStop() {
        super.onStop()
        Timber.e("$TAG ------------------> onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.e("$TAG ------------------> onDestroy()")
    }

}