package com.ljt.newmvvm.ui.home.Adapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.ljt.mvvmdemo.utilities.glides.GlideApp


@BindingAdapter("src")
fun showImageSrc(view: ImageView, url: String ){
    GlideApp.with(view).load(url).into(view)
}
