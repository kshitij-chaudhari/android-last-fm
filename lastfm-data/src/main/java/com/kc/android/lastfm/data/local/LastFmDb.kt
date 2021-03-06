/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kc.android.lastfm.data.local.daos.AlbumDao
import com.kc.android.lastfm.data.local.daos.RemoteKeyDao
import com.kc.android.lastfm.data.local.entities.AlbumEntity
import com.kc.android.lastfm.data.local.entities.RemoteKeyEntity

/**
 * Main DB class for the application which defines all the entities and exposes dao classes.
 */
@Database(entities = [AlbumEntity::class, RemoteKeyEntity::class], version = 1, exportSchema = false)
abstract class LastFmDb : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
    abstract fun remoteKeyDao(): RemoteKeyDao
}
