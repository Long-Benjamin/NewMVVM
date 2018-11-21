package com.ljt.newmvvm.ui.home

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.ljt.newmvvm.R
import com.ljt.newmvvm.base.ui.BaseFragment
import com.ljt.newmvvm.databinding.FragmentBlankBinding
import kotlinx.android.synthetic.main.fragment_blank.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BlankFragment : BaseFragment<FragmentBlankBinding>() {
    private var param1: String? = null
    private var param2: String? = null

    override fun initView() {
        getBinding().btJump.setOnClickListener {
            tv_description.let {
                it.text = "如果跳转返回过来还能看到这条数据，说明跳转后对页面的UI没有影响!"
            }
            NavHostFragment.findNavController(this).navigate(R.id.action_blankFragment_to_blank2Fragment)
        }
    }

    override fun initParam() {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_blank
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                BlankFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
