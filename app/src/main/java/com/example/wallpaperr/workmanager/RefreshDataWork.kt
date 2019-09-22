package com.example.wallpaperr.workmanager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.wallpaperr.App
import com.example.wallpaperr.model.ImageDatabase
import com.example.wallpaperr.model.ImageRepository
import retrofit2.HttpException
import javax.inject.Inject

class RefreshDataWork(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {

    @Inject
    lateinit var repository: ImageRepository

    companion object {
        const val WORK_NAME = "RefreshDataWork"
    }

    init {
        (appContext as App).component.inject(this)
    }


    override suspend fun doWork(): Payload {

        return try {
          //  repository.refreshVideos()
            Payload(Result.SUCCESS)
        } catch (exception: HttpException) {
            Payload(Result.RETRY)
        }
    }

}
