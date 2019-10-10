package com.example.wallpaperr.mainscreen

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.example.wallpaperr.domain.Images
import timber.log.Timber


@BindingAdapter("listImages")
fun bindRecyclerView(recyclerView: RecyclerView, images: List<Images>?){
    images?.let {
        Timber.d("Update recycler view")
        val adapter = recyclerView.adapter as PictureGridAdapter
        adapter.submitList(images)
    }

}

@BindingAdapter("imageGrid")
fun bindImages( imgView : ImageView, imgUrlString : String){
   imgUrlString.let {
      Glide.with(imgView.context)
          .load(imgUrlString)
          .into(imgView)
        }
    }
