package com.codewith.databinding.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.RequestOptions
import com.codewith.databinding.R

class CustomBingUtil {
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun setImageUrl(imageView: ImageView,url: String) {
            Glide.with(imageView).load(url)
                .apply(RequestOptions().placeholder(R.drawable.add_photo_female).error(R.drawable.add_photo_female))
                .into(imageView)
        }
    }
}