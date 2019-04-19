package com.zk.gaokaopro.viewModel

import com.zk.gaokaopro.model.GKBaseBean
import io.reactivex.Observable

class MainMoreParamsViewModel : BaseViewModel<String> () {
    var id = ""

    override fun getObservable(): Observable<GKBaseBean<String>> {
        return gkApi.requestTestAddParams(id)
    }


//    var id = ""
//    override fun getObservable(): Observable<GKBaseBean<String>> {
//        return gkApi.requestTestAddParams(id)
//    }
}