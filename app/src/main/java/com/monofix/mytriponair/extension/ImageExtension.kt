package com.monofix.mytriponair.extension

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.monofix.mytriponair.R


fun AppCompatImageView.loadURL(imgURL: String?) {
    Glide.with(this)
        .load(imgURL)
        .centerCrop()
        .placeholder(R.drawable.ic_default)
        .into(this)
}

fun AppCompatImageView.loadURL(imgURL: String?, radius: Int) {
    Glide.with(this)
        .load(imgURL)
        .placeholder(R.drawable.ic_default)
        .into(this)
}

fun AppCompatImageView.loadURL(bitmap: Bitmap?) {
    Glide.with(this)
        .load(bitmap)
        .placeholder(R.drawable.ic_default)
        .into(this)
}

fun AppCompatImageView.loadURL(drawable: Drawable?) {
    Glide.with(this)
        .load(drawable)
        .placeholder(R.drawable.ic_default)
        .into(this)
}