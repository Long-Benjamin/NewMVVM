package com.ljt.mvvmdemo.base.http

import com.ljt.mvvmdemo.base.type.GankResult
import com.ljt.newmvvm.base.http.entity.MeizhiBean
import com.ljt.newmvvm.base.http.entity.Result
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET
    fun getUserInfo(@Field("userid") userid: String): Observable<Result<MeizhiBean>>

    @GET("data/福利/10/{page}")
    fun getMeizhiData(@Path("page") page: Int): Observable<GankResult<List<MeizhiBean>>>

}