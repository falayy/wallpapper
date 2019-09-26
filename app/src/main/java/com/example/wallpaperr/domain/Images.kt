package com.example.wallpaperr.domain


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Images(
    val id: Int,
    val fullImage: String,
    val previewImageUrl: String
) : Parcelable