package com.example.wallpaperr.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

abstract class BaseViewModel (val startCoroutines : CoroutineDispatcher) : ViewModel() {
    private val job = Job()

    val coroutineScope = CoroutineScope(job + startCoroutines)


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}