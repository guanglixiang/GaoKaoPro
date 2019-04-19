package com.zk.gaokaopro.activity

import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zk.gaokaopro.R
import com.zk.gaokaopro.model.GKBaseBean
import com.zk.gaokaopro.model.RecommendBean
import com.zk.gaokaopro.viewModel.RecommendViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

//                viewModel.requestRecommend()

//                questionDetailViewModel = ViewModelProviders.of(this).get(QuestionDetailViewModel::class.java)


                gkApi.requestRecommend().enqueue(object : Callback<GKBaseBean<ArrayList<RecommendBean>>> {
                    override fun onFailure(call: Call<GKBaseBean<ArrayList<RecommendBean>>>, t: Throwable) {
                        message.text = t.message
                    }

                    override fun onResponse(
                        call: Call<GKBaseBean<ArrayList<RecommendBean>>>,
                        response: Response<GKBaseBean<ArrayList<RecommendBean>>>
                    ) {
                        message.text = response.body()!!.result.toString()
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
