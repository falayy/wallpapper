package com.example.wallpaperr.images

import android.app.WallpaperManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.example.wallpaperr.domain.Images
import com.example.wallpaperr.domain.SetWallpaper
import com.example.wallpaperr.model.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject


class ImageViewModel @Inject constructor(private val imageRepository: ImageRepository) :
    ViewModel() {
    val images = imageRepository.images

    private val _navigateToFullImage = MutableLiveData<Images>()
    val navigateToFullImage: LiveData<Images>
        get() = _navigateToFullImage

    init {
        viewModelScope.launch {
            imageRepository.refreshImages()
        }
    }



    fun onNavigateToFullImage(image: Images) {
        _navigateToFullImage.value = image
    }

    fun onNavigateToFullImageComplete() {
        _navigateToFullImage.value = null

    }
}