package com.ljt.mvvmdemo.base.http

import okhttp3.Interceptor
import okhttp3.Response

/**
 * 统一添加请求头部拦截器
 */
class NetworkIntereptor : Interceptor{

    private val KEY_USER_AGENT = "User-Agent"
    private var userAgent: String

    constructor(){
        val shomthing = "Android"
        this.userAgent = shomthing
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val requestUserAgent = request.newBuilder()
                .addHeader(KEY_USER_AGENT, userAgent)
                .build()
        return chain.proceed(requestUserAgent)
    }

}