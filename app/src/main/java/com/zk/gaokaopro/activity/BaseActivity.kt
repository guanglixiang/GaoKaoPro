package com.zk.gaokaopro.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.zk.gaokaopro.api.GKApi
import team.zhuoke.sdk.manager.ZKConnectionManager

abstract class BaseActivity : AppCompatActivity() {

    lateinit var gkApi: GKApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewId())
        getIntentData()

        getGKApk()

        getViewModel()
        setViewModelObserve()

        initViews()
        setListener()

        initData()
    }

    /**
     * 获取 gkApi 对象
     */
    private fun getGKApk() {
        val connectionManager = ZKConnectionManager.getInstance()
        gkApi = connectionManager.getApi(GKApi::class.java) as GKApi
    }

    @LayoutRes
    abstract fun getContentViewId(): Int

    abstract fun getIntentData()

    abstract fun getViewModel()

    abstract fun setViewModelObserve()

    abstract fun initViews()

    abstract fun setListener()

    abstract fun initData()
}