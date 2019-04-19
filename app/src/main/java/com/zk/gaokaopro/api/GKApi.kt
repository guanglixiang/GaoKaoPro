package com.zk.gaokaopro.api

import com.zk.gaokaopro.model.GKBaseBean
import com.zk.gaokaopro.model.RecommendBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GKApi {

    @GET(UrlConfig.URL_TEST)
//    fun requestTest(): Call<GKBaseBean<String>>
    fun requestTest(): Observable<GKBaseBean<String>>

    @GET(UrlConfig.URL_RECOMMEND)
    fun requestRecommend(): Observable<GKBaseBean<ArrayList<RecommendBean>>>

    @GET(UrlConfig.URL_TEST)
    fun requestTestAddParams(@Query("id") id: String): Observable<GKBaseBean<String>>

}