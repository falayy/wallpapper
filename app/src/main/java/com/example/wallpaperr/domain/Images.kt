package com.example.wallpaperr.domain


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageURL")
    val fullImage: String,
    @SerializedName("previewURL")
    val previewImageUrl: String
)
