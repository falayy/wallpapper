package com.example.wallpaperr.model


import androidx.lifecycle.Transformations
import com.example.wallpaperr.network.asDatabaseModel
import com.example.wallpaperr.networkutils.GENERIC_ERROR_CODE
import com.example.wallpaperr.networkutils.GENERIC_ERROR_MESSAGE
import com.example.wallpaperr.networkutils.Result
import com.example.wallpaperr.networkutils.getAPIResult
import com.example.wallpaperr.services.ImageApiService
import kotlinx.coroutines.Dispatchers
import com.example.wallpaperr.model.asDomainModel
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val imageDatabase: ImageDatabase,
    private val imageApiService: ImageApiService
) {

    val images = Transformations.map(imageDatabase.imageDao.getImages()) {
        Timber.d("We got called::: ${it.size}")
        it.asDomainModel()
    }

    suspend fun refreshImages() {
        withContext(Dispatchers.IO) {
            try {
                when (val result = getAPIResult(imageApiService.searchImages())) {
                    is Result.Success -> {
                        imageDatabase.imageDao.dropImageTable()
                        imageDatabase.imageDao.insertAllImages(*result.data.hits.asDatabaseModel())
                        Timber.d("We got called::: ${result.data.hits.size}")
                    }
                    is Result.Error -> {
                        Timber.d("Error: ${result.errorMessage}")
                    }

                }
            } catch (e: Exception) {
                Timber.e(e)
                Result.Error(GENERIC_ERROR_CODE, e.message ?: GENERIC_ERROR_MESSAGE)
            }


        }
    }
}