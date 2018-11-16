package com.ljt.newmvvm.ui.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment
import com.ljt.mvvmdemo.utilities.glides.GlideApp
import com.ljt.newmvvm.R
import com.ljt.newmvvm.base.ui.BaseFragment
import com.ljt.newmvvm.databinding.FragmentBlank2Binding
import com.ljt.newmvvm.ui.home.viewmodel.BlankViewModel
import kotlinx.android.synthetic.main.fragment_blank2.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Blank2Fragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Blank2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class Blank2Fragment : BaseFragment<FragmentBlank2Binding>(){


    private var param1: String? = null
    private var param2: String? = null
    private lateinit var text_view: TextView
    private lateinit var mTextVM : BlankViewModel


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                Blank2Fragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

    override fun initParam() {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        mTextVM = ViewModelProviders.of(this).get(BlankViewModel::class.java)
        val textObserver = Observer<String>{
            text_view.text = it
        }
        mTextVM.textOne.observe(this, textObserver)
    }

    override fun getLayoutId(): Int = R.layout.fragment_blank2

    override fun initView() {
        text_view = getBinding().textView
        getBinding().blankVM = mTextVM
        getBinding().setLifecycleOwner(this)
        getBinding().btTo3.setOnClickListener {
            mTextVM.textOne.value = "000000000"
            NavHostFragment.findNavController(this).navigate(R.id.action_blank2Fragment_to_blank3Fragment)
        }
        getBinding().btTo4.setOnClickListener {
            mTextVM.textOne.value = "1111111111"
            NavHostFragment.findNavController(this).navigate(R.id.action_blank2Fragment_to_blank4Fragment)
        }
    }


    override fun onDestroyView() {
        GlideApp.with(img_view).clear(img_view)
        super.onDestroyView()
    }
}
