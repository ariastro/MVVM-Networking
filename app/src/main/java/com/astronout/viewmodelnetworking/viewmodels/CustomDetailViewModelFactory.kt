package com.astronout.viewmodelnetworking.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.astronout.viewmodelnetworking.models.ListPlaceResponseModel

class CustomDetailViewModelFactory (private val model: ListPlaceResponseModel.ListPlaceModel, private val application: Application) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return DetailViewModel(
            model,
            application
        ) as T
    }

}