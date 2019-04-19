package com.zk.gaokaopro.activity

import android.text.TextUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.blankj.utilcode.util.ToastUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zk.gaokaopro.GKConstant
import com.zk.gaokaopro.R
import com.zk.gaokaopro.viewModel.RecommendViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.text = "请求网络数据"

                val viewModel = ViewModelProviders.of(this).get(RecommendViewModel::class.java)
                viewModel.liveData.observe(this, Observer {
                    if (it != null) {
                        val errorCode = it.code
                        if (errorCode == GKConstant.CODE_SUCCESS) {
                            message.text = it.result.toString()
//                            LiveDataBus.instance.getChannel(EventConstants.CONSULTATION_VIEW_COUNT_EVENT, RefreshData::class.java)
//                                .postValue(refreshData)
                            return@Observer
                        }
                    }

                    val msg = it.msg
                    if (!TextUtils.isEmpty(msg))
                        ToastUtils.showShort(msg)
                })

                viewModel.requestData()

                oldRequest()

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun oldRequest() {
        //旧的网络层使用方法
        //                gkApi.requestRecommend().enqueue(object : Callback<GKBaseBean<ArrayList<RecommendBean>>> {
        //                    override fun onFailure(call: Call<GKBaseBean<ArrayList<RecommendBean>>>, t: Throwable) {
        //                        message.text = t.message
        //                    }
        //
        //                    override fun onResponse(
        //                        call: Call<GKBaseBean<ArrayList<RecommendBean>>>,
        //                        response: Response<GKBaseBean<ArrayList<RecommendBean>>>
        //                    ) {
        //                        message.text = response.body()!!.result.toString()
        //                    }
        //
        //                })
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
