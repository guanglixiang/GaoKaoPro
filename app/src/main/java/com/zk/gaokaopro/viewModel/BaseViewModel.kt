package com.zk.gaokaopro.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zk.gaokaopro.api.GKApi
import com.zk.gaokaopro.model.GKBaseBean
import com.zk.gaokaopro.model.RecommendBean
import io.reactivex.Observable
import team.zhuoke.sdk.manager.ZKConnectionManager

abstract class BaseViewModel<T> : ViewModel() {
    var gkApi: GKApi

    init {
        val connectionManager = ZKConnectionManager.getInstance()
        gkApi = connectionManager.getApi(GKApi::class.java) as GKApi
    }

    @SuppressLint("CheckResult")
    fun subscribeA(observable : Observable<GKBaseBean<ArrayList<RecommendBean>>>,
                   liveData: MutableLiveData<GKBaseBean<ArrayList<RecommendBean>>>) {


//        gkApi.requestRecommend().subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe {
//                object : GKHttpSubscriber<GKBaseBean<ArrayList<RecommendBean>>>() {
//                    override fun onSuccess(t: GKBaseBean<ArrayList<RecommendBean>>) {
////                        liveData.value = GKBaseBean.success(t.result)
//                    }
//
//                    override fun onOtherError(e: Throwable) {
//                        liveData.value = GKBaseBean.otherError(null)
//                    }
//
//                    override fun onResponseError(errorCode: Int, message: String) {
//                        liveData.value = GKBaseBean.error(errorCode, message, null)
//                    }
//
//                }
//            }
    }


//    @SuppressLint("CheckResult")
//    fun subscribeList(observable: Observable<GKListBaseBean<ArrayList<T>>>, liveData: MutableLiveData<ArrayList<T>>) {
//
////        GKBaseBean<ArrayList<RecommendBean>>
//
//        observable.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe {
//                object : GKHttpSubscriberList<GKListBaseBean<ArrayList<T>>>() {
//                    override fun onSuccess(t: GKListBaseBean<ArrayList<T>>) {
//                        liveData.value = GKListBaseBean.success(t.result)
//                    }
//
//                    override fun onOtherError(e: Throwable) {
//                        liveData.value = GKListBaseBean.otherError(null)
//                    }
//
//                    override fun onResponseError(errorCode: Int, message: String) {
//                        liveData.value = GKListBaseBean.error(errorCode, message, null)
//                    }
//                }
//            }
//    }
//}




}