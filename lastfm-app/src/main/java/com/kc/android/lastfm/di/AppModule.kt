/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.di

import com.kc.android.lastfm.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

/**
 * Application specific dependencies to be added in this [Module]
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Application module is responsible to initialise the LASTFM_API_KEY. This avoids hard-coding in the
     * other modules. Other modules can access the LASTFM_API_KEY using [Named] annotation as used below.
     */
    @Singleton
    @Provides
    @Named("lastfm-api-key")
    fun provideLastFmApiKey() = BuildConfig.LASTFM_API_KEY
}
