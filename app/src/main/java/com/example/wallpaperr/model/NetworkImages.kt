package com.example.wallpaperr.model
import com.example.wallpaperr.network.Hit
import com.google.gson.annotations.SerializedName

data class NetworkImages(
    @SerializedName("hits")
    val hits: List<Hit>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalHits")
    val totalHits: Int
)