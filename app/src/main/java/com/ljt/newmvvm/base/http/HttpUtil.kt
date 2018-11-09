package com.ljt.mvvmdemo.base.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

class HttpUtil private constructor(){

    companion object {
        val INSTANCE : HttpUtil by lazy {
            HttpUtil()
        }
    }

    val BASE_URL = ""
    var apiService : ApiService? = null

    fun okhttpClient() : OkHttpClient{
        return OkHttpClient().newBuilder()
                .connectTimeout(20,TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .addNetworkInterceptor(getLoggingInterceptor())
//                .addInterceptor(MyIntereptor())
                .addInterceptor(NetworkIntereptor())
                .build()
    }

    /**
     *  这段代码可以使用拦截器和@Headers 的信息来动态处理地址
     */
    fun getRetrofit(url: String) : Retrofit{
        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient())
                .build()
        return retrofit
    }

    fun getLoggingInterceptor() : HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Timber.e(it)
        })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun getApiServer(): ApiService? {
        if (apiService == null) {
            apiService = getRetrofit(BASE_URL).create(ApiService::class.java)
        }
        return apiService
    }

}