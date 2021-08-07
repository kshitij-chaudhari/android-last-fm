/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kc.android.lastfm.data.local.entities.AlbumEntity
import kotlinx.coroutines.flow.Flow

/**
 * Album Dao class to expose all DB operations for `albums` table.
 */
@Dao
interface AlbumDao {
    @Query("SELECT * FROM albums WHERE id = :albumId")
    fun get(albumId: Int): Flow<AlbumEntity>

    @Query("SELECT * FROM albums ORDER BY id")
    fun getAll(): Flow<List<AlbumEntity>>

    @Query("DELETE FROM albums")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg albumEntity: AlbumEntity)
}
