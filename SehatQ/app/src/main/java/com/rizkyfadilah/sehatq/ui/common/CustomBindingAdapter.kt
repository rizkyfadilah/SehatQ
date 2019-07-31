package com.rizkyfadilah.sehatq.ui.common

import androidx.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

object CustomBindingAdapter{

    @JvmStatic
    @BindingAdapter("bind:image_url")
    fun loadImage(imageView: ImageView, url: String) {
        Picasso.with(imageView.context).load(url).into(imageView)
    }

    @JvmStatic
    @BindingAdapter("bind:image_drawable")
    fun loadImageDrawable(imageView: ImageView, imageDrawable: Int) {
        imageView.setImageResource(imageDrawable)
//        Picasso.with(imageView.context).load(imageDrawable).into(imageView)
    }

}