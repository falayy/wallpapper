package com.example.wallpaperr.WorkManager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.wallpaperr.model.ImageRepository
import retrofit2.HttpException

class RefreshDataWork (appContext : Context, params : WorkerParameters)
    : CoroutineWorker(appContext, params){
    companion object{
        const val WORK_NAME = "RefreshDataWork"
    }

    init {


    }
    override suspend fun doWork(): Payload {
//        val database = getDatabase(applicationContext)
        val repository = ImageRepository(database)

        return try {
//            repository.refreshVideos()
            Payload(Result.SUCCESS)
        }catch (exception : HttpException){
            Payload(Result.RETRY)
        }
    }

}
