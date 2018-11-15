package com.ljt.newmvvm

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkStatus
import com.ljt.newmvvm.worker.MyWorker
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

        MainApplication.getInstance()
    }

    override fun onSupportNavigateUp() = findNavController(R.id.home_nav_host_fragment).navigateUp()

    override fun onStart() {
        super.onStart()
        val myWorker = OneTimeWorkRequestBuilder<MyWorker>().build()
        WorkManager.getInstance().enqueue(myWorker)
        WorkManager.getInstance().getStatusById(myWorker.id).observe(this, object: Observer<WorkStatus> {
            override fun onChanged(t: WorkStatus?) {
                Timber.e("00000000011111111= ${t?.state.toString()}")
                if (t != null && t.state.isFinished){

                }
            }

        })


    }

    /**
     * 【已解决】Android Navigation组件，没法判断当前Fragment是否是栈底的，
     *    也没法代码设置返回到指定Fragment；只能返回键一步步后退
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK
                &&event?.action == KeyEvent.ACTION_DOWN){

            /**终于攻克了这一步了，哈哈哈哈， 返回键手动回退Fragment，最底层Fragment模拟home键效果*/
            if (findNavController(R.id.home_nav_host_fragment).popBackStack())return true

            //实现返回键App后台运行，Home键的效果
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
            this.startActivity(intent)
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}
