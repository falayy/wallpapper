package com.example.wallpaperr.domain


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Images(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageURL")
    val fullImage: String,
    @SerializedName("previewURL")
    val previewImageUrl: String
) : Parcelable