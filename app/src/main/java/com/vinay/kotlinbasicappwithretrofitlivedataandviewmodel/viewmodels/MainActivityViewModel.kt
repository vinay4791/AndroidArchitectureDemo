package com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.viewmodels

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.api.ServiceManager
import com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.api.ServiceManagerProvider
import com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.model.PhotosModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel (application: Application) : BaseViewModel(application) {

    var serviceManager: ServiceManager? = null
    val photosModel = MutableLiveData<List<PhotosModel>>()

    init {
        serviceManager = ServiceManagerProvider.provideSearchRepository()
    }

    fun getData() {

        serviceManager!!.getDataList()
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
            ?.subscribe({ result ->
               photosModel.postValue(result.body())
            }, { error ->

            })

    }

}