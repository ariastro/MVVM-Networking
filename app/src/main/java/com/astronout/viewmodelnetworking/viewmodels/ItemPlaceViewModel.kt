package com.astronout.viewmodelnetworking.viewmodels

import android.content.Intent
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.astronout.viewmodelnetworking.models.ListPlaceResponseModel
import com.astronout.viewmodelnetworking.views.DetailActivity

class ItemPlaceViewModel(private val model: ListPlaceResponseModel.ListPlaceModel): ViewModel() {

    var title: ObservableField<String> = ObservableField()
    var location: ObservableField<String> = ObservableField()
    var image: ObservableField<String> = ObservableField()

    init {
        title.set(model.name)
        location.set(model.location)
        image.set(model.image)
    }

    fun itemClick(view: View){
        val context = view.context
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_DATA_GALLERY, model)
        context.startActivity(intent)
    }

}