package com.zk.gaokaopro.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zk.gaokaopro.api.GKApi
import com.zk.gaokaopro.model.GKBaseBean
import com.zk.gaokaopro.subscriber.GKHttpSubscriber
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import team.zhuoke.sdk.manager.ZKConnectionManager

abstract class BaseViewModel<T> : ViewModel() {


    companion object {
        const val TAG = "BaseViewModel"
    }


    val liveData = MutableLiveData<GKBaseBean<T>>()

    var gkApi: GKApi

    init {
        val connectionManager = ZKConnectionManager.getInstance()
        gkApi = connectionManager.getApi(GKApi::class.java) as GKApi
    }

    @SuppressLint("CheckResult")
    private fun request(observable : Observable<GKBaseBean<T>>) {
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : GKHttpSubscriber<GKBaseBean<T>>() {
                override fun onSuccess(t: GKBaseBean<T>) {
                    liveData.value = GKBaseBean.success(t.result)
                }

                override fun onOtherError(e: Throwable) {
                    liveData.value = GKBaseBean.otherError(null)
                }

                override fun onResponseError(errorCode: Int, message: String) {
                    liveData.value = GKBaseBean.error(errorCode, message, null)
                }

            })
    }

    fun requestData() {
        return request(getObservable())
    }

    abstract fun getObservable(): Observable<GKBaseBean<T>>

    private fun logD(msg: String) {
        Log.d(TAG, msg)
    }

    var successCallBack : SuccessCallBack<T>? = null

    fun callData(result: T?) {
        if (successCallBack != null) {
            successCallBack!!.success(result)
        }
    }

    interface SuccessCallBack<T> {
        fun success(result: T?)
    }

}