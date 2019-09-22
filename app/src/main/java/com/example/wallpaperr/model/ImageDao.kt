package com.example.wallpaperr.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import javax.inject.Inject

@Dao
interface ImageDao {

    @Query("select *from databaseimages ")
    fun getImages() : LiveData<List<DatabaseImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllImages(vararg images: DatabaseImages)

}


@Database(entities = [DatabaseImages::class], version = 1)
abstract class ImageDatabase : RoomDatabase() {
    abstract val imageDao : ImageDao
}