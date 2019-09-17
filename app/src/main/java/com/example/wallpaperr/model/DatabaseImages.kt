package com.example.wallpaperr.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.wallpaperr.domain.Images

@Entity
data class DatabaseImages constructor(
    @PrimaryKey
    val id: Int,
    val previewImageUrl: String,
    val fullImage: String
) {


    fun List<DatabaseImages>.asDomainModel(): List<Images> {
        return map {
            Images(
                id = it.id,
                previewImageUrl = it.previewImageUrl,
                fullImage = it.fullImage
            )
        }
    }


}