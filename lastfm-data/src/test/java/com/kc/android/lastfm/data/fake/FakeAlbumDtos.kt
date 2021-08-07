/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.fake

import com.kc.android.lastfm.data.remote.dtos.AlbumDto
import com.kc.android.lastfm.data.remote.dtos.ImageDto

/**
 * Fake [AlbumDto] instances for testing.
 */
object FakeAlbumDtos {
    val believe = AlbumDto(
        mbid = "c559efc2-f734-41ae-93bd-2d78414e0356",
        name = "Believe",
        artist = "Disturbed",
        url = "https://www.last.fm/music/Disturbed/Believe",
        image = listOf(
            ImageDto(url = "https://lastfm.freetls.fastly.net/i/u/34s/dcf5cf4b9da64e979719a102acd222cc.png", size = "small"),
            ImageDto(url = "https://lastfm.freetls.fastly.net/i/u/64s/dcf5cf4b9da64e979719a102acd222cc.png", size = "medium"),
            ImageDto(url = "https://lastfm.freetls.fastly.net/i/u/174s/dcf5cf4b9da64e979719a102acd222cc.png", size = "large"),
            ImageDto(url = "https://lastfm.freetls.fastly.net/i/u/300x300/dcf5cf4b9da64e979719a102acd222cc.png", size = "extralarge")
        )
    )
}
