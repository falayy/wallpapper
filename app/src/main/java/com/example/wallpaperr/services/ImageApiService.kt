package com.example.wallpaperr.services

import com.example.wallpaperr.Constants
import com.example.wallpaperr.network.NetworkImage
import retrofit2.Response
import retrofit2.http.GET


interface ImageApiService {

    @GET("api/?key=${Constants.API_KEY}")
    suspend fun searchImages(): Response<List<NetworkImage>>

}
