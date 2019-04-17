package com.zk.gaokaopro.activity

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zk.gaokaopro.R
import com.zk.gaokaopro.api.GKApi
import com.zk.gaokaopro.model.GKBaseBean
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import team.zhuoke.sdk.manager.ZKConnectionManager

class MainActivity : BaseActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.text = "请求网络数据"

                val connectionManager = ZKConnectionManager.getInstance()
                val gkApi = connectionManager.getApi(GKApi::class.java) as GKApi
                gkApi.requestTest().enqueue(object : Callback<GKBaseBean> {
                    override fun onResponse(call: Call<GKBaseBean>, response: Response<GKBaseBean>) {
                        message.text = response.body()!!.toString()
                    }

                    override fun onFailure(call: Call<GKBaseBean>, t: Throwable) {
                        message.text = t.message
                    }
                })

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun getContentViewId(): Int {
        return R.layout.activity_main
    }

    override fun getIntentData() {


//        ZKConnectionManager.getInstance().getApi()
    }

    override fun getViewModel() {
    }

    override fun setViewModelObserve() {
    }

    override fun initViews() {
    }

    override fun setListener() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun initData() {

    }

}
