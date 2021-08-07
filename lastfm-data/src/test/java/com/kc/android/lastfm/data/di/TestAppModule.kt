/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

/**
 * Fake API key const declared to be used while verifying.
 */
internal const val FAKE_API_KEY = "FAKE_KEY"

/**
 * [dagger.hilt.testing.TestInstallIn] is not needed here since we not replacing the AppModule.
 * Rather this code is in `data` module tested independently
 */
@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    /**
     * Fake LastFm Api Key needed from other retrofit modules.
     * No real network call is made, so fake should be fine.
     */
    @Singleton
    @Provides
    @Named("lastfm-api-key")
    fun provideLastFmApiKey() = FAKE_API_KEY
}
