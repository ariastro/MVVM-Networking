package com.astronout.viewmodelnetworking.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.astronout.viewmodelnetworking.R
import com.astronout.viewmodelnetworking.databinding.ActivityDetailBinding
import com.astronout.viewmodelnetworking.models.ListPlaceResponseModel
import com.astronout.viewmodelnetworking.viewmodels.CustomDetailViewModelFactory
import com.astronout.viewmodelnetworking.viewmodels.DetailViewModel

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA_GALLERY = "extra_detail"
    }

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        if (intent.extras != null){
            val placeModel:ListPlaceResponseModel.ListPlaceModel = intent.getParcelableExtra(EXTRA_DATA_GALLERY)!!
            viewModel = ViewModelProviders.of(this,
                CustomDetailViewModelFactory(
                placeModel,
                application
                )
            ).get(
                DetailViewModel::class.java
            )
            binding.detailPlace = viewModel
            supportActionBar?.title = placeModel.name
        }

    }
}
