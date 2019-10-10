package com.example.wallpaperr.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ImageDao {

    @Query("SELECT * FROM databaseimages")
    fun getImages(): LiveData<List<DatabaseImages>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllImages(vararg images: DatabaseImages)

    @Delete
    fun delete(user: DatabaseImages)

    @Query("DELETE FROM databaseimages")
    fun dropImageTable()
}


