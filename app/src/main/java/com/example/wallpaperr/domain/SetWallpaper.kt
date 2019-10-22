package com.example.wallpaperr.domain

import android.graphics.Bitmap
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.FutureTarget
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class SetWallpaper {

    suspend fun setWallpaper(imageString: String, view: View) {
        withContext(Dispatchers.IO) {
            Glide.with(view.context)
                .asBitmap()
                .load(imageString)
                .submit()

        }
    }

}