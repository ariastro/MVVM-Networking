package com.astronout.viewmodelnetworking.viewmodels

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.astronout.viewmodelnetworking.models.ListPlaceResponseModel

class DetailViewModel(model: ListPlaceResponseModel.ListPlaceModel, application: Application): ViewModel(){

    var title: ObservableField<String> = ObservableField(model.name)
    var location: ObservableField<String> = ObservableField(model.location)
    var image: ObservableField<String> = ObservableField(model.image)

}