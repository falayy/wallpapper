package com.example.wallpaperr.model


import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.wallpaperr.domain.Images
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ImageRepository @Inject constructor( imageDatabase: ImageDatabase) {


    val images : LiveData<List<Images>>? = Transformations.map(imageDatabase.imageDao.getImages()){
        it.asDomainModel()
    }

suspend fun refreshImages(){
    withContext(Dispatchers.IO){
//        val networkImages =
//        imageDatabase.imageDao.insertAllImages(*networkImages.asDatabaseModel())
    }
}
}