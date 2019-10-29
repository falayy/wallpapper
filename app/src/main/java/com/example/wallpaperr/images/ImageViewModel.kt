package com.example.wallpaperr.images

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.RequestManager
import com.example.wallpaperr.base.BaseViewModel
import com.example.wallpaperr.domain.Images
import com.example.wallpaperr.model.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ImageViewModel @Inject constructor(private val imageRepository: ImageRepository) :
    BaseViewModel() {
    val images = imageRepository.images

    private val _imageBitMap = MutableLiveData<Bitmap>()


    private val _navigateToFullImage = MutableLiveData<Images>()
    val imageBitmap: LiveData<Bitmap>
        get() = _imageBitMap
    val navigateToFullImage: LiveData<Images>
        get() = _navigateToFullImage

    init {
        viewModelScope.launch {
            imageRepository.refreshImages()
        }
    }

    fun decode(requestManager: RequestManager, url: String) {
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
              val  tempImageBitMap = requestManager.asBitmap().load(url).submit(1080, 1920).get()
                _imageBitMap.postValue(tempImageBitMap)
            }

        }
    }

    fun onNavigateToFullImage(image: Images) {
        _navigateToFullImage.value = image
    }

    fun onNavigateToFullImageComplete() {
        _navigateToFullImage.value = null

    }
}