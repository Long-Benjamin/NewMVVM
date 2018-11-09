package com.ljt.mvvmdemo.base.http

import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response


/**
 * 网络请求返回数据日志打印
 */
class MyIntereptor : Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val startTime = System.currentTimeMillis()
        val response = chain.proceed(chain.request())
        val endTime = System.currentTimeMillis()
        val duration = endTime - startTime
        val mediaType = response.body()!!.contentType()
        val content = response.body()!!.string()

//        LogUtil.debug("\n")
//        LogUtil.debug("》---------Start---------------》")
//        LogUtil.debug( "| " + request.toString())

        val method = request.method()
        if ("POST" == method) {
            val sb = StringBuilder()
            if (request.body() is FormBody) {
                val body = request.body() as FormBody
                for (i in 0 until body.size()) {
                    sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",")
                }
                sb.delete(sb.length - 1, sb.length)
//                LogUtil.debug( "| RequestParams:{" + sb.toString() + "}")
            }
        }

//        LogUtil.debug( "| Response:$content")
//        LogUtil.debug( "《---------End:" + duration + "毫秒---------《")

        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build()
    }

}