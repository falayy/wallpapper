package com.example.wallpaperr.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DatabaseImages::class], version = 1, exportSchema = false)
abstract class ImageDatabase : RoomDatabase() {
    abstract val imageDao: ImageDao
}