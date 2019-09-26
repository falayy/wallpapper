package com.example.wallpaperr.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ImageDao {

    @Query("SELECT * FROM DatabaseImages")
    fun getImages(): LiveData<List<DatabaseImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllImages(vararg images: DatabaseImages): Array<Long>
}


@Database(entities = [DatabaseImages::class], version = 1)
abstract class ImageDatabase : RoomDatabase() {
    abstract val imageDao: ImageDao
}