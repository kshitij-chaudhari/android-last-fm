/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * DB Entity representation of [com.kc.android.lastfm.data.remote.dtos.AlbumDto].
 */
@Entity(tableName = "albums")
data class AlbumEntity(
    // there doesn't seem to be an id passed by lastfm, so locally generating one.
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val mbid: String,
    val name: String,
    val artist: String,
    val url: String,
    val smallImage: String?,
    val mediumImage: String?,
    val largeImage: String?,
    val extraLargeImage: String?
)
