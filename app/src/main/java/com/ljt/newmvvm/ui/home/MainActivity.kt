package com.ljt.newmvvm.ui.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.ljt.newmvvm.R

/**
 * 【首页】
 *  1、作为Navigation的容器使用
 *  2、返回键退出App到后台，再次打开不进入闪屏页
 *  3、使用NavigationBar做首页的页面切换
 */
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

    override fun onStart() {
        super.onStart()

       /* val myWorker = OneTimeWorkRequestBuilder<MyWorker>().build()
        WorkManager.getInstance().enqueue(myWorker)
        WorkManager.getInstance().getStatusById(myWorker.id).observe(this, object: Observer<WorkStatus> {
            override fun onChanged(t: WorkStatus?) {
                if (t != null && t.state.isFinished){

                }
            }

        })*/


    }

    /**
     * 【已解决】也没法代码设置返回到指定Fragment，只能返回键一步步后退？
     *  假如现在是fragment_1 -> 2 -> 3 -> 4 跳转，要想在fragment_4直接返回1，并将2、3 推出栈，
     *  可在action中使用属性 app:popUpTo="@id/fragment_1"，即可实现效果
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK
                &&event?.action == KeyEvent.ACTION_DOWN){

            /**终于攻克了这一步了，哈哈哈哈， 返回键手动回退Fragment，最底层Fragment模拟 HOME 键效果*/
            if (findNavController(R.id.home_nav_host_fragment).popBackStack())return true

            //模仿音乐播放App，实现返回键App后台运行，再次进入不走闪屏页
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
            this.startActivity(intent)
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}
