package com.zk.gaokaopro.model

import com.google.gson.annotations.SerializedName


data class GKBaseBean<T>(
    @SerializedName("code") val code: Int,
    @SerializedName("msg") val msg: String,
    @SerializedName("result") val result: T
)