package com.example.wallpaperr.images

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaperr.domain.Images
import com.example.wallpaperr.model.ImageRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


class ImageViewModel @Inject constructor(private val imageRepository: ImageRepository) :
    ViewModel() {

    private val _navigateToFullImage = MutableLiveData<Images>()
    val navigateToFullImage: LiveData<Images>
        get() = _navigateToFullImage

    init {
        viewModelScope.launch {
            imageRepository.refreshImages()
        }
    }

    fun getListOfImages(): List<Images> {
        imageRepository.images?.value?.let {
            return it
        }
        return ArrayList()
    }

    fun onNavigateToFullImage(image: Images) {
        _navigateToFullImage.value = image
    }

    fun onNavigateToFullImageComplete() {
        _navigateToFullImage.value = null

    }
}