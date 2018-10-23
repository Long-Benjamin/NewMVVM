package com.ljt.newmvvm.ui.home

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import timber.log.Timber

open class BaseFragment : Fragment(){

    val TAG = this.javaClass.simpleName

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Timber.e("$TAG------------------>onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.e("$TAG------------------>onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        Timber.e(TAG,"------------------>onCreateView()")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e("$TAG------------------>onViewCreated()")
    }

    override fun onStart() {
        super.onStart()
        Timber.e("$TAG------------------>onStart()")
    }

    override fun onResume() {
        super.onResume()
        Timber.e("$TAG------------------>onResume()")
    }

    override fun onPause() {
        super.onPause()
        Timber.e("$TAG------------------>onPause()")
    }

    override fun onStop() {
        super.onStop()
        Timber.e("$TAG------------------>onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.e("$TAG------------------>onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.e("$TAG------------------>onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.e("$TAG------------------>onDetach()")
    }
}