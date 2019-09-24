package com.example.wallpaperr.images

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaperr.base.BaseViewModel
import com.example.wallpaperr.domain.Images
import com.example.wallpaperr.model.ImageRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ImageViewModel @Inject constructor(private val imageRepository: ImageRepository) :
    ViewModel() {

    init {
        viewModelScope.launch {
            imageRepository.refreshImages()
        }
    }

    fun getListOfImages() : LiveData<List<Images>> {
      val imageList = imageRepository.images
        return imageList!!
    }
}