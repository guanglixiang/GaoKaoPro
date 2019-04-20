package com.zk.gaokaopro.model

import com.google.gson.annotations.SerializedName
import com.zk.gaokaopro.api.GKHttpStatusCode.Companion.REQUEST_NET_ERROR


data class GKListBaseBean<T>(
    @SerializedName("code") val code: Int,
    @SerializedName("msg") val msg: String,
    @SerializedName("result") val result: ArrayList<T>?
) {

    companion object {
        fun <T> success(data: ArrayList<T>?) = GKListBaseBean(0, "", data)

        fun <T> error(errorCode: Int, msg: String, data: ArrayList<T>?) = GKListBaseBean(errorCode, msg, data)

        fun <T> otherError(data: ArrayList<T>?) = GKListBaseBean(
            REQUEST_NET_ERROR,
            "网络出错",
            data
        )

    }
}