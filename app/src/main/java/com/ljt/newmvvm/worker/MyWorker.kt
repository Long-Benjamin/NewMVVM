package com.ljt.newmvvm.worker

import androidx.work.Worker
import timber.log.Timber
import kotlin.concurrent.thread

class MyWorker : Worker() {

    override fun doWork(): Result {

        thread {
            var i = 10
            while (i>0){
                i--
                Timber.e("aasasasasasas+++++ $i")
                Thread.sleep(1000)
            }
        }

        return Result.SUCCESS
    }
}