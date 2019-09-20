package com.example.wallpaperr.di.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.wallpaperr.base.BaseViewModel
import com.example.wallpaperr.domain.Images
import com.example.wallpaperr.model.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ImageViewModel @Inject constructor(private val imageRepository: ImageRepository) : BaseViewModel(Dispatchers.Main) {


    init {
        coroutineScope.launch {
        imageRepository.refreshImages()
        }
    }


    fun getListOfImages(){
      val imageList = imageRepository.images
    }


}