package com.zk.gaokaopro.viewModel

import com.zk.gaokaopro.model.GKBaseBean
import com.zk.gaokaopro.model.RecommendBean
import io.reactivex.Observable

class RecommendViewModel : BaseViewModel<ArrayList<RecommendBean>>() {

    override fun getObservable(): Observable<GKBaseBean<ArrayList<RecommendBean>>> {
        return gkApi.requestRecommend()
    }

}