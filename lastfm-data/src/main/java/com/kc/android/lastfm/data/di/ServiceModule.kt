/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.di

import com.kc.android.lastfm.data.remote.services.LastFmService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Singleton
    @Provides
    fun provideLastFmService(retrofit: Retrofit): LastFmService =
        retrofit.create(LastFmService::class.java)
}
