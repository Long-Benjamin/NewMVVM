package com.ljt.newmvvm.coroutine

import kotlinx.coroutines.*


/**
 * runBlocking用于main函数或test函数,用于实现类似主协程的效果
 */
fun main(args: Array<String>) = runBlocking{

    val job = GlobalScope.launch {

        dos()
        print("\n协程日志1")

        delay(500)
        print("\n协程日志2")
    }

    Thread.sleep(400)
    job.cancelAndJoin()
    print("\n主线程日志1")

}

/**
 * 协程中调用的方法需要suspend 修饰
 */
suspend fun dos() {

    repeat(10,action = {
        delay(100)
        println("在这里休息——》  $it ...")
    })
    print("\n协程1.1")

}
