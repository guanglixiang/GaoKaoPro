package com.zk.gaokaopro.api

import com.zk.gaokaopro.model.GKBaseBean
import retrofit2.Call
import retrofit2.http.GET

public interface GKApi {

    @GET(UrlConfig.URL_TEST)
    abstract fun requestTest(): Call<GKBaseBean>
}