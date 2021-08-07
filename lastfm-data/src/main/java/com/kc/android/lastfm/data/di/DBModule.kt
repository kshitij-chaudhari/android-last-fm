/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.di

import android.content.Context
import androidx.room.Room
import com.kc.android.lastfm.data.local.LastFmDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module for Db dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Singleton
    @Provides
    fun provideLastFmDb(@ApplicationContext context: Context): LastFmDb =
        Room.databaseBuilder(context, LastFmDb::class.java, "lastfm_db")
            .build()
}
