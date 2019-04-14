package com.zk.gaokaopro

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewId())
        getIntentData()

        getViewModel()
        setViewModelObserve()

        initViews()
        setListener()

        initData()
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