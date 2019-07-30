package com.astronout.viewmodelnetworking.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.astronout.viewmodelnetworking.models.ListPlaceResponseModel
import com.astronout.viewmodelnetworking.networks.repositories.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MainRepository()

    val listPlace: MutableLiveData<ListPlaceResponseModel> = MutableLiveData()
    val error: MutableLiveData<Throwable> = MutableLiveData()

    fun getListPlace(){
        repository.requestListPlace({
            listPlace.postValue(it)
        },{
            error.postValue(it)
        })
    }



}