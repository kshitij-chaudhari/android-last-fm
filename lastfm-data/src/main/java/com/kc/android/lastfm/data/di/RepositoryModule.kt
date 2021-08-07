/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.di

import com.kc.android.lastfm.data.local.LastFmDb
import com.kc.android.lastfm.data.remote.services.LastFmService
import com.kc.android.lastfm.data.repositories.AlbumRepositoryImpl
import com.kc.android.lastfm.domain.repositories.AlbumRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideLastFmRepository(
        db: LastFmDb,
        service: LastFmService
    ): AlbumRepository = AlbumRepositoryImpl(db, service)
}
