package com.zk.gaokaopro.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.zk.gaokaopro.model.GKBaseBean
import com.zk.gaokaopro.model.RecommendBean

class MainViewModel : BaseViewModel<String> () {

    val recommendViewModel = MutableLiveData<GKBaseBean<RecommendBean>>()


    @SuppressLint("CheckResult")
    fun requestRecommend() {

        var a = recommendViewModel

//        var cls = RecommendBean::class.objectInstance



//        gkApi.requestRecommend().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
//            object : GKHttpSubscriber<GKBaseBean<T>>() {
//
//                override fun onSuccess(t: GKBaseBean<T>) {
//
//
//                }
//
//                override fun onOtherError(e: Throwable) {
//
//                }
//
//                override fun onResponseError(errorCode: Int, message: String) {
//
//                }
//
//            }
//        )


//        val observable = gkApi.requestRecommend()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe { object : GKHttpSubscriber<GKBaseBean<RecommendBean>>() {
//                override fun onSuccess(t: GKBaseBean<RecommendBean>) {
//                    recommendViewModel.value = GKBaseBean.success(t.result)
//                }
//
//                override fun onOtherError(e: Throwable) {
//                    recommendViewModel.value = GKBaseBean.otherError(null)
//                }
//
//                override fun onResponseError(errorCode: Int, message: String) {
//                    recommendViewModel.value = GKBaseBean.error(errorCode, message, null)
//                }
//
//            } }
    }

}