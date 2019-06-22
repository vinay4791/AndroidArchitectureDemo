package com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.api;

import com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.model.PhotosModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response


class ServiceManager {

    var apiInterface: ApiInterface? = null

    init {
        apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface::class.java)
    }
    fun getDataList(): Observable<Response<List<PhotosModel>>> {
        return apiInterface!!.getPhotos("1").subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map({ response -> response })
    }

}
