package com.ljt.newmvvm.ui.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.aurelhubert.ahbottomnavigation.notification.AHNotification
import com.ljt.newmvvm.R
import com.ljt.newmvvm.base.ui.FragmentsManager
import com.ljt.newmvvm.ui.home.Blank2Fragment
import com.ljt.newmvvm.ui.home.Blank3Fragment
import com.ljt.newmvvm.ui.home.Blank4Fragment
import com.ljt.newmvvm.ui.home.BlankFragment
import com.ljt.newmvvm.util.PreferencesHelper.enableTranslucent
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private lateinit var fragmentsManager: FragmentsManager
    private lateinit var blankFragment: BlankFragment
    private lateinit var blank2Fragment: Blank2Fragment
    private lateinit var blank3Fragment: Blank3Fragment
    private lateinit var blank4Fragment: Blank4Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(if (enableTranslucent) R.style.AppTheme_TranslucentNavigation else R.style.AppTheme)
        setContentView(R.layout.activity_home)

        initFragment()
        initView()
    }

    private fun initFragment() {
        fragmentsManager = FragmentsManager(this@HomeActivity)
        blankFragment = BlankFragment.newInstance("0","0")
        blank2Fragment = Blank2Fragment.newInstance("0","0")
        blank3Fragment = Blank3Fragment.newInstance("0","0")
        blank4Fragment = Blank4Fragment.newInstance("0","0")
    }

    private fun initView() {
        val item1 = AHBottomNavigationItem(R.string.home_nav_home, R.drawable.ic_nav_home, R.color.colorPrimary)
        val item2 = AHBottomNavigationItem(R.string.home_nav_news, R.drawable.ic_nav_news, R.color.colorAccent)
        val item3 = AHBottomNavigationItem(R.string.home_nav_vedios, R.drawable.ic_nav_vedio, R.color.colorPrimary)
        val item4 = AHBottomNavigationItem(R.string.home_nav_my, R.drawable.ic_nav_my, R.color.colorAccent)

        bottom_navigation.addItem(item1)
        bottom_navigation.addItem(item2)
        bottom_navigation.addItem(item3)
        bottom_navigation.addItem(item4)
        // Set background color
        bottom_navigation.setDefaultBackgroundColor(Color.parseColor("#ffffff"))
        // Disable the translation inside the CoordinatorLayout
        bottom_navigation.setBehaviorTranslationEnabled(false)
        // Enable the translation of the FloatingActionButton
        bottom_navigation.manageFloatingActionButtonBehavior(floating_action_button)

        // Manage titles
        bottom_navigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW)

        // Use colored navigation with circle reveal effect
        bottom_navigation.setColored(true)

        // Customize notification (title, background, typeface)
        bottom_navigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"))

        // Add or remove notification for each item
        bottom_navigation.setNotification("999", 3)
        // OR
        val notification = AHNotification.Builder()
                .setText("1")
                .setBackgroundColor(ContextCompat.getColor(this@HomeActivity, R.color.color_notification_back))
                .setTextColor(ContextCompat.getColor(this@HomeActivity, R.color.color_notification_text))
                .build()
        bottom_navigation.setNotification(notification, 1)

        // Set listeners
        bottom_navigation.setOnTabSelectedListener { position, wasSelected ->

            if(wasSelected)false

            when(position){
                0 -> consume { fragmentsManager.addFragment(blankFragment) }
                1 -> consume { fragmentsManager.addFragment(blank2Fragment)}
                2 -> consume { fragmentsManager.addFragment(blank3Fragment)}
                3 -> consume { fragmentsManager.addFragment(blank4Fragment)}
                else -> false
            }

        }

        // Set current item programmatically
        bottom_navigation.setCurrentItem(0)

    }

    inline fun consume(f: () -> Unit): Boolean {
        f()
        return true
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        fragmentsManager.popFragment()

        //以下退出方式，可以释放内存占用
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        this.startActivity(intent)

        System.exit(0)
        return true
    }

}
