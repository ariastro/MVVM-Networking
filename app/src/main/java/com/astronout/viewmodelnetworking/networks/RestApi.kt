package com.astronout.viewmodelnetworking.networks

import com.astronout.viewmodelnetworking.models.ListPlaceResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {

    @GET("Sample.json")
    fun getListPlace(): Observable<ListPlaceResponseModel>

}