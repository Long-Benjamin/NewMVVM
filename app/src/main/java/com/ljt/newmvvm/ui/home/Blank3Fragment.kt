package com.ljt.newmvvm.ui.home

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.ljt.newmvvm.R
import com.ljt.newmvvm.base.ui.BaseFragment
import com.ljt.newmvvm.base.ui.MainNavigationFragment
import com.ljt.newmvvm.databinding.FragmentBlank3Binding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Blank3Fragment : BaseFragment<FragmentBlank3Binding>() {
    private var param1: String? = null
    private var param2: String? = null

    override fun initParam() {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_blank3

    override fun initView() {
        getBinding().btnTo1.setOnClickListener {
            NavHostFragment.findNavController(this@Blank3Fragment).navigate(R.id.action_blank3Fragment_to_blankFragment)
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                Blank3Fragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
