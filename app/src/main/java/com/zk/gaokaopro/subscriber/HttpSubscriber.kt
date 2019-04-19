package com.zk.gaokaopro.subscriber

import android.util.Log
import com.zk.gaokaopro.api.GKHttpStatusCode
import com.zk.gaokaopro.model.GKBaseBean
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.net.UnknownHostException

abstract class GKHttpSubscriber<T : GKBaseBean<*>> : Observer<T> {

    private val TAG = "GKHttpSubscriber"

    override fun onSubscribe(d: Disposable) {

    }

    override fun onComplete() {

    }

    override fun onNext(t: T) {
        if (t.code == GKHttpStatusCode.REQUEST_SUCCESS) {
            if (t.result == null) {
                onOtherError(Exception("result is null"))
            } else {
                onSuccess(t)
            }
        } else {
            onResponseError(t.code, t.msg)
        }
    }

    override fun onError(e: Throwable) {
        onOtherError(e)
        when (e) {
            is HttpException -> {
                Log.e(TAG, "HttpException")
            }
            is UnknownHostException -> {
                Log.e(TAG, "UnknownHostException")
            }
            else -> {
                Log.e(TAG, "other")
            }
        }
    }

    protected abstract fun onSuccess(t: T)

    protected abstract fun onOtherError(e: Throwable)

    protected abstract fun onResponseError(errorCode: Int, message: String)
}