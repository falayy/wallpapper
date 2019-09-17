package com.example.wallpaperr.network

import android.content.res.TypedArray
import com.example.wallpaperr.domain.Images
import com.example.wallpaperr.model.DatabaseImages
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NetworkImageContainer(val images : List<NetworkImage>)


@JsonClass(generateAdapter = true)
data class NetworkImage(val id : Int, val previewImageUrl : String, val fullImage : String){

}



fun NetworkImageContainer.asDomainModel() : List<Images> {
    return images.map {
        Images(
            id = it.id,
            previewImageUrl = it.previewImageUrl,
            fullImage = it.fullImage
        )
    }
}

    fun NetworkImageContainer.asDatabaseModel() : Array<DatabaseImages>{
        return images.map {
            DatabaseImages(
                id = it.id,
                previewImageUrl =  it.previewImageUrl,
                fullImage =  it.fullImage

            )
        }.toTypedArray()
    }
