/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.domain.di

import com.kc.android.lastfm.domain.interactors.AlbumUseCase
import com.kc.android.lastfm.domain.interactors.AlbumUseCaseImpl
import com.kc.android.lastfm.domain.repositories.AlbumRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module to provide all use-case dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideAlbumUseCase(repository: AlbumRepository): AlbumUseCase =
        AlbumUseCaseImpl(repository)
}
