package com.example.wallpaperr.mainscreen

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import com.bumptech.glide.Glide
import com.example.wallpaperr.domain.Images
import kotlinx.android.synthetic.main.image_grid_item.view.*

@BindingAdapter("imageGrid")
fun ImageView.setImages (imgUrl : String?, imgView : ImageView){
    imgUrl?.let {
      Glide.with(imgView.context)
          .load(imgUrl)
          .into(imgView)
        }
    }