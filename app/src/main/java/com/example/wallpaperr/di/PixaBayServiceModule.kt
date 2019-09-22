package com.example.wallpaperr.di

import android.os.Build
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.NetworkType
import androidx.work.WorkerParameters
import com.cottacush.android.androidbaseprojectkt.auth.*
import com.example.wallpaperr.BuildConfig
import com.example.wallpaperr.network.AccessTokenProviderImpl
import com.example.wallpaperr.services.ImageAPIAuthService
import com.example.wallpaperr.services.ImageApiService
import com.google.gson.Gson
import dagger.Lazy
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [LocalDataModule::class])
class PixaBayServiceModule {


    @Provides
    @Named("ImageAPIService")
    @Singleton
    fun provideExampleServiceHttpClient(
        upstream: OkHttpClient,
        @Named("ImageAPIService") accessTokenProvider: AccessTokenProvider
    ): OkHttpClient {
        return upstream.newBuilder()
            .addInterceptor(AccessTokenInterceptor(accessTokenProvider))
            .authenticator(AccessTokenAuthenticator(accessTokenProvider))
            .build()
    }

    @Provides
    @Singleton
    fun provideExampleAPIAuthService(
        client: Lazy<OkHttpClient>,
        gson: Gson
    ): ImageAPIAuthService {
        return Retrofit.Builder()
            .baseUrl(ImageAPIAuthService.ENDPOINT)
            .client(client.get())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ImageAPIAuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideExampleAPIService(
        @Named("ImageAPIService") client: Lazy<OkHttpClient>,
        gson: Gson
    ): ImageApiService {
        return Retrofit.Builder()
            .baseUrl(ImageApiService.BASE_URL)
            .client(client.get())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ImageApiService::class.java)
    }


    @Provides
    @Singleton
    fun provideWorkManagerConstraint(): Constraints {
        return Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresBatteryNotLow(true)
            .setRequiresCharging(true)
            .apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    setRequiresDeviceIdle(true)
                }
            }.build()
    }

    @Provides
    @Named("ImageAPIService")
    fun provideAccessTokenProvider(accessTokenProvider: AccessTokenProviderImpl): AccessTokenProvider =
        accessTokenProvider

    @Provides
    @Singleton
    fun provideGenericOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)
}
