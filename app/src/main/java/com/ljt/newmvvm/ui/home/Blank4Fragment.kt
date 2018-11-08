package com.ljt.newmvvm.ui.home

import android.os.Bundle
import com.ljt.newmvvm.R
import com.ljt.newmvvm.base.ui.BaseFragment
import com.ljt.newmvvm.databinding.FragmentBlank4Binding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Blank4Fragment : BaseFragment<FragmentBlank4Binding>() {
    private var param1: String? = null
    private var param2: String? = null

    override fun initParam() {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_blank4
    }

    override fun initView() {

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                Blank4Fragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
