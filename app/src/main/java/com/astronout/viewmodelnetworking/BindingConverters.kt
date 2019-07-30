package com.astronout.viewmodelnetworking

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions

class BindingConverters {

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, url: String){
            Glide.with(imageView.context)
                .load(url)
                .apply(RequestOptions()
                    .placeholder(R.drawable.ic_refresh_black_24dp)
                    .error(R.drawable.ic_refresh_black_24dp)
                    .format(DecodeFormat.PREFER_ARGB_8888))
                .into(imageView)
        }
    }

}