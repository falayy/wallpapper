package com.example.wallpaperr.services

import com.example.wallpaperr.Constants
import com.example.wallpaperr.network.NetworkImageContainer
import retrofit2.Response
import retrofit2.http.GET


interface ImageApiService {

    @GET("api")
    suspend fun searchImages(): Response<NetworkImageContainer>

}
