package com.example.wallpaperr.di

import android.app.Application
import androidx.room.Room
import com.example.wallpaperr.model.ImageDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun provideImageDatabase(app: Application): ImageDatabase {
        return Room.databaseBuilder(
            app, ImageDatabase::class.java,
            "images"
        ).build()
    }
}
