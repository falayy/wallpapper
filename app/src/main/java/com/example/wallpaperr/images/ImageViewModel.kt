package com.example.wallpaperr.images

import androidx.lifecycle.viewModelScope
import com.example.wallpaperr.base.BaseViewModel
import com.example.wallpaperr.model.ImageRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ImageViewModel @Inject constructor(private val imageRepository: ImageRepository) :
    BaseViewModel() {

    init {
        viewModelScope.launch {
            imageRepository.refreshImages()
        }
    }

    fun getListOfImages() {
        val imageList = imageRepository.images
    }
}