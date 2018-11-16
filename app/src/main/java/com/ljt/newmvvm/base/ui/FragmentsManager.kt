package com.ljt.newmvvm.base.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.ljt.newmvvm.R
import java.util.*

class FragmentsManager{

    companion object {
        private const val FRAGMENT_ID = R.id.fragment_container
    }

    private var fragmentManager: FragmentManager
    private var currentFragment: Fragment = Fragment()
    private var fragmentStack = Stack<Fragment>()

    constructor(fragmentActivity: FragmentActivity){
        fragmentManager = fragmentActivity.supportFragmentManager
    }

    fun <F> replaceFragment(fragment: F) where F : Fragment, F : MainNavigationFragment {
        fragmentManager.beginTransaction().replace(FRAGMENT_ID, fragment).commit()
        currentFragment = fragment

    }

    /**
     * @param fragment: 需要显示页面，判断是否已经包含在栈中
     */
    fun <F> addFragment(fragment: F) where F : Fragment {

        if (fragmentStack.contains(fragment)){

                fragmentManager.beginTransaction()
                        .show(fragment)
                        .commit()

                fragmentManager.beginTransaction()
                        .hide(currentFragment)
                        .commit()

        }else{
            fragmentManager.beginTransaction()
                    .add(FRAGMENT_ID, fragment,fragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            fragmentStack.add(fragment)
        }

        currentFragment = fragment

    }

    fun popFragment(){
        fragmentStack.clear()
    }

}