package com.zk.gaokaopro.api

import com.zk.gaokaopro.GKConstant

object UrlConfig {

    /**
     * 全局的域名地址
     */
    private var BASE_URL = GKConstant.BASE_URL

    fun getBaseUrl(): String {
        return BASE_URL
    }

    const val URL_TEST = "test"
}