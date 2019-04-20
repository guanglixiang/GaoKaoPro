package com.zk.gaokaopro.viewModel

import com.zk.gaokaopro.model.GKBaseBean
import io.reactivex.Observable

class MainViewModel : BaseViewModel<String> () {
    override fun getObservable(): Observable<GKBaseBean<String>> {
        return gkApi.requestTest()
    }
}