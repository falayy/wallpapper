package com.example.wallpaperr.network

import com.example.wallpaperr.domain.Images
import com.example.wallpaperr.model.DatabaseImages
import com.google.gson.annotations.SerializedName


data class NetworkImageContainer(val hits: List<NetworkImage>)


data class NetworkImage(
    @SerializedName("id")
    val id: Int, @SerializedName("previewURL") val previewImageUrl: String,
    @SerializedName("imageURL") val fullImage: String
)


fun NetworkImageContainer.asDomainModel(): List<Images> {
    return hits.map {
        Images(
            id = it.id,
            previewImageUrl = it.previewImageUrl,
            fullImage = it.fullImage
        )
    }
}

fun NetworkImageContainer.asDatabaseModel(): Array<DatabaseImages> {
    return hits.map {
        DatabaseImages(
            id = it.id,
            previewImageUrl = it.previewImageUrl,
            fullImage = it.fullImage
        )
    }.toTypedArray()
}