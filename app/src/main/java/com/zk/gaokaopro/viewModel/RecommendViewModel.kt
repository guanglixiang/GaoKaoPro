package com.zk.gaokaopro.viewModel

import androidx.lifecycle.MutableLiveData
import com.zk.gaokaopro.model.GKBaseBean
import com.zk.gaokaopro.model.RecommendBean

class RecommendViewModel: BaseViewModel<ArrayList<RecommendBean>>() {

    val recommendViewModel = MutableLiveData<GKBaseBean<ArrayList<RecommendBean>>>()

    fun requestRecommend() {
//        subscribeA(gkApi.requestRecommend(), recommendViewModel)

//        gkApi.requestRecommend().subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
////            .subscribe(object : GKHttpSubscriber<GKBaseBean<ArrayList<RecommendBean>>>() {
//            .subscribe(object : GKHttpSubscriber<GKBaseBean<String>>() {
//                override fun onSuccess(t: GKBaseBean<String>) {
//                    Log.d("TAG", "bbbb")
////                    recommendViewModel.value = GKBaseBean.success(t.result)
//                }
//
//                override fun onOtherError(e: Throwable) {
//                    recommendViewModel.value = GKBaseBean.otherError(null)
//                }
//
//                override fun onResponseError(errorCode: Int, message: String) {
//                    recommendViewModel.value = GKBaseBean.error(errorCode, message, null)
//                }
//            })

//        Api.getInstance().getINorthStar().requestQuestionDetail(id)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : HttpSubscriber<BaseResult<QuestionDetailBean>>() {
//                override fun onSuccess(t: BaseResult<QuestionDetailBean>) {
//                    questionDetailModel.value = BaseResult.success(t.result)
//                }
//
//                override fun onOtherError(e: Throwable) {
//                    questionDetailModel.value = BaseResult.otherError(null)
//                }
//
//                override fun onResponseError(errorCode: Int, message: String) {
//                    questionDetailModel.value = BaseResult.error(errorCode, message, null)
//                }
//
//            })

    }
}