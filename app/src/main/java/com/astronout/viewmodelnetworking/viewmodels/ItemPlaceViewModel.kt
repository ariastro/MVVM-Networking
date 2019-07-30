package com.astronout.viewmodelnetworking.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.astronout.viewmodelnetworking.models.ListPlaceResponseModel

class ItemPlaceViewModel(model: ListPlaceResponseModel.ListPlaceModel): ViewModel() {

    var title: ObservableField<String> = ObservableField()
    var location: ObservableField<String> = ObservableField()
    var image: ObservableField<String> = ObservableField()

    init {
        title.set(model.name)
        location.set(model.location)
        image.set(model.image)
    }

}