package com.example.wallpaperr.services

import com.example.wallpaperr.network.NetworkImageContainer
import retrofit2.Response
import retrofit2.http.GET


interface ImageApiService {

    companion object {
        const val  BASE_URL = "https://pixabay.com/"
    }

    @GET("api")
    suspend fun searchImages(): Response<NetworkImageContainer>

}
