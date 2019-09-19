package com.example.wallpaperr.services

import com.example.wallpaperr.model.DatabaseImages
import com.example.wallpaperr.network.NetworkImageContainer
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl("")
    .build()


interface ImageApiService {

    @GET("")
    fun getAllImages():
            Deferred<NetworkImageContainer>

}

object ImageApiClient {

    val retrofitService: ImageApiService by lazy {
        retrofit.create(ImageApiService::class.java)
    }
}