package com.ljt.newmvvm

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.ljt.newmvvm.base.http.entity.DataBean
import com.ljt.newmvvm.ui.home.BlankFragment
import timber.log.Timber
import java.util.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val finalHost = NavHostFragment.create(R.navigation.nav_graph)
        supportFragmentManager.beginTransaction()
                .replace(R.id.home_nav_host_fragment, finalHost)
                .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
                .commit()

    }

    override fun onSupportNavigateUp() = findNavController(R.id.home_nav_host_fragment).navigateUp()


    override fun onBackPressed() {
        super.onBackPressed()
    }
}
