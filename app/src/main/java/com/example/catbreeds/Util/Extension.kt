package com.example.catbreeds.Util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.catbreeds.R
import com.example.catbreeds.model.İmage

fun ImageView.downloadImage(image: İmage?, progressDrawable: CircularProgressDrawable) {

    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.ic_icon_logo)

    Glide.with(context).load(image?.url).into(this)
}

fun placeholderProgress(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        this.backgroundColor = context.getColor(R.color.meow_light_yellow)
        this.strokeWidth = 5f
        this.centerRadius = 30f
        this.start()
    }

}

@BindingAdapter("android:downloadImage")
fun downloadImage(view: ImageView, image: İmage?) {
    view.downloadImage(image, placeholderProgress(view.context))
}