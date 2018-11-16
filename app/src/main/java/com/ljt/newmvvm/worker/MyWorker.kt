package com.ljt.newmvvm.worker

import androidx.work.Worker
import timber.log.Timber
import java.io.File
import java.io.FileInputStream
import kotlin.concurrent.thread

class MyWorker : Worker() {

//    启动方式
/* val myWorker = OneTimeWorkRequestBuilder<MyWorker>().build()
       WorkManager.getInstance().enqueue(myWorker)
       WorkManager.getInstance().getStatusById(myWorker.id).observe(this, object: Observer<WorkStatus> {
           override fun onChanged(t: WorkStatus?) {
               if (t != null && t.state.isFinished){

               }
           }

       })*/
    override fun doWork(): Result {

        thread {
            var i = 10
            while (i>0){
                i--
//                Timber.e("aasasasasasas+++++ $i")
                Thread.sleep(1000)
            }
        }

        return Result.SUCCESS
    }
}