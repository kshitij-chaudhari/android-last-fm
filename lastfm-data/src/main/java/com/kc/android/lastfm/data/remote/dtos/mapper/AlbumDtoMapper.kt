/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.remote.dtos.mapper

import com.kc.android.lastfm.data.local.entities.AlbumEntity
import com.kc.android.lastfm.data.remote.dtos.AlbumDto

/**
 * Map [AlbumDto] to [com.kc.android.lastfm.data.local.entities.AlbumEntity].
 * This is usually needed for db insertion.
 */
fun AlbumDto.toAlbumEntity() = AlbumEntity(
    mbid = this.mbid,
    name = this.name,
    artist = this.artist,
    url = this.url,
    smallImage = this.image.firstOrNull { it.size == "small" }?.url,
    mediumImage = this.image.firstOrNull { it.size == "medium" }?.url,
    largeImage = this.image.firstOrNull { it.size == "large" }?.url,
    extraLargeImage = this.image.firstOrNull { it.size == "extralarge" }?.url,
)
