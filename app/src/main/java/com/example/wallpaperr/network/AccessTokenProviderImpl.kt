package com.example.wallpaperr.network

import com.cottacush.android.androidbaseprojectkt.auth.AccessTokenProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccessTokenProviderImpl @Inject constructor() : AccessTokenProvider {

    private val apiKey = "11101652-d5c9874aaa15474c7264f2224"

    override fun token(): String? {
        return apiKey
    }

    override fun refreshToken(): String? {
        return apiKey
    }
}
