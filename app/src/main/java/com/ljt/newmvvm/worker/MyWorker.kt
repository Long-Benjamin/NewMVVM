package com.ljt.newmvvm.worker

import androidx.work.Worker
import timber.log.Timber

class MyWorker : Worker() {

    override fun doWork(): Result {

        Thread({
            var i = 10
            while (i>0){
                i--
                Timber.e("aasasasasasas+++++ $i")
                Thread.sleep(1000)
            }
        }).start()

        return Result.SUCCESS
    }
}