package com.example.wallpaperr.model


import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.wallpaperr.domain.Images
import com.example.wallpaperr.network.asDatabaseModel
import com.example.wallpaperr.networkutils.GENERIC_ERROR_CODE
import com.example.wallpaperr.networkutils.GENERIC_ERROR_MESSAGE
import com.example.wallpaperr.networkutils.Result
import com.example.wallpaperr.networkutils.getAPIResult
import com.example.wallpaperr.services.ImageApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val imageDatabase: ImageDatabase,
    private val imageApiService: ImageApiService
) {

    val images: LiveData<List<Images>>? = Transformations.map(imageDatabase.imageDao.getImages()) {
        it.asDomainModel()
    }

    suspend fun refreshImages() {
        withContext(Dispatchers.IO) {
            try {
                when (val result = getAPIResult(imageApiService.searchImages())) {
                    is Result.Success -> {
                        imageDatabase.imageDao.insertAllImages(*result.data.asDatabaseModel())
                    }
                    is Result.Error -> {
                        Timber.d("Error: ${result.errorMessage}")
                    }
                }

            } catch (e: Exception) {
                Result.Error(GENERIC_ERROR_CODE, e.message ?: GENERIC_ERROR_MESSAGE)
            }
        }
    }
}