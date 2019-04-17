package com.zk.gaokaopro.api

import com.zk.gaokaopro.model.GKBaseBean
import com.zk.gaokaopro.model.RecommendBean
import retrofit2.Call
import retrofit2.http.GET

interface GKApi {

    @GET(UrlConfig.URL_TEST)
    fun requestTest(): Call<GKBaseBean<String>>

    @GET(UrlConfig.URL_RECOMMEND)
    fun requestRecommend(): Call<GKBaseBean<ArrayList<RecommendBean>>>
}