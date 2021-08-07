/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.local.entities.mapper

import com.kc.android.lastfm.data.local.entities.AlbumEntity
import com.kc.android.lastfm.domain.models.Album

/**
 * Map [AlbumEntity] to [com.kc.android.lastfm.domain.models.Album].
 */
fun AlbumEntity.toAlbum() = Album(
    id = this.id,
    mbid = this.mbid,
    name = this.name,
    artist = this.artist,
    url = this.url,
    smallImage = this.smallImage,
    mediumImage = this.mediumImage,
    largeImage = this.largeImage
)
