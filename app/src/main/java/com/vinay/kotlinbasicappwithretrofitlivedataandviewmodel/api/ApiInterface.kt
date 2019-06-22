package com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.api;

import com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.model.PhotosModel
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {
    @GET("/albums/{albumId}/photos")
    fun getPhotos(@Path("albumId") albumId: String): Observable<Response<List<PhotosModel>>>
}