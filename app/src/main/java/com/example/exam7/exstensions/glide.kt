package com.example.exam7.exstensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.exam7.R

fun ImageView.setImage(url: String?) {

    if (!url.isNullOrEmpty()) {
        Glide.with(context).load(url).placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher_round)
            .into(this)
    }

}