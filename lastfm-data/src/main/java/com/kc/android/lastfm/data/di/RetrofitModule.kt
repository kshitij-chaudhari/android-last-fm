/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.di

import com.kc.android.lastfm.data.remote.LastFmOkHttpInterceptor
import com.kc.android.lastfm.data.remote.services.LastFmService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * All the [Retrofit] and [OkHttpClient] dependencies are initialised here for easier replacement
 * if needed during testing.
 */
@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(LastFmService.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        lastFmOkHttpInterceptor: LastFmOkHttpInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(httpLoggingInterceptor)
        .addInterceptor(lastFmOkHttpInterceptor)
        .build()

    /**
     * An implementation of [HttpLoggingInterceptor] to set the logging level
     */
    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    /**
     * "lastfm-api-key" is provided by application module and will be injected here when application is run.
     * For testing a test dagger module will need to be created to inject a fake api-key
     */
    @Singleton
    @Provides
    fun provideLastFmOkHttpInterceptor(@Named("lastfm-api-key") lastfmApiKey: String) =
        LastFmOkHttpInterceptor(lastfmApiKey)
}
