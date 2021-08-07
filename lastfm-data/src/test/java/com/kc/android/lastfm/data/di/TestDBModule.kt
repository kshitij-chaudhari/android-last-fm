/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.di

import android.content.Context
import androidx.room.Room
import com.kc.android.lastfm.data.local.LastFmDb
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

/**
 * Test module for DB to replace the [DBModule] with a in-memory version.
 */
@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DBModule::class]
)
object TestDBModule {

    @Singleton
    @Provides
    fun provideLastFmDb(@ApplicationContext context: Context): LastFmDb =
        Room.inMemoryDatabaseBuilder(context, LastFmDb::class.java)
            .allowMainThreadQueries()
            .build()
}
