package com.example.wallpaperr.mainscreen

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.example.wallpaperr.R
import com.example.wallpaperr.domain.Images
import timber.log.Timber


@BindingAdapter("listImages")
fun bindRecyclerView(recyclerView: RecyclerView, images: List<Images>?) {
    images?.let {
        Timber.d("Update recycler view")
        val adapter = recyclerView.adapter as PictureGridAdapter
        adapter.submitList(images)
    }

}

@BindingAdapter("imageGrid")
fun bindImages(imgView: ImageView, imgUrlString: String) {
    imgUrlString.let {
        Glide.with(imgView.context)
            .load(imgUrlString)
            .placeholder(R.drawable.ic_file_download_black_24dp)
            .into(imgView)
    }
}
