package com.example.wallpaperr.model

import android.net.Network
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.wallpaperr.domain.Images
import com.example.wallpaperr.network.asDatabaseModel
import com.example.wallpaperr.services.ImageApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ImageRepository @Inject constructor(val imageDatabase: ImageDatabase) {


    val images : LiveData<List<Images>>? = Transformations.map(imageDatabase.imageDao.getImages()){
        it.asDomainModel()
    }

suspend fun refreshImages(){
    withContext(Dispatchers.IO){
        val networkImages = ImageApiClient.retrofitService.getAllImages().await()
        imageDatabase.imageDao.insertAllImages(*networkImages.asDatabaseModel())
    }
}
}