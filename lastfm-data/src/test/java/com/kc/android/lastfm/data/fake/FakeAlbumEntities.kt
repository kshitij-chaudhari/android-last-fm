/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.fake

import com.kc.android.lastfm.data.local.entities.AlbumEntity

/**
 * Fake [AlbumEntity] instances for testing.
 */
object FakeAlbumEntities {
    fun believe(id: Int = 0) = AlbumEntity(
        id = id,
        mbid = "c559efc2-f734-41ae-93bd-2d78414e0356",
        name = "Believe",
        artist = "Disturbed",
        url = "https://www.last.fm/music/Disturbed/Believe",
        smallImage = "https://lastfm.freetls.fastly.net/i/u/34s/dcf5cf4b9da64e979719a102acd222cc.png",
        mediumImage = "https://lastfm.freetls.fastly.net/i/u/64s/dcf5cf4b9da64e979719a102acd222cc.png",
        largeImage = "https://lastfm.freetls.fastly.net/i/u/174s/dcf5cf4b9da64e979719a102acd222cc.png",
        extraLargeImage = "https://lastfm.freetls.fastly.net/i/u/300x300/dcf5cf4b9da64e979719a102acd222cc.png"
    )

    fun makeBelieve(id: Int = 0) = AlbumEntity(
        id = id,
        mbid = "9e7103bb-fc9a-4e5a-a90c-2a3ab4c08e19",
        name = "Make Believe",
        artist = "Weezer",
        url = "https://www.last.fm/music/Weezer/Make+Believe",
        smallImage = "https://lastfm.freetls.fastly.net/i/u/34s/1c8439b16ed4ca4e0bac727e7b325581.png",
        mediumImage = "https://lastfm.freetls.fastly.net/i/u/64s/1c8439b16ed4ca4e0bac727e7b325581.png",
        largeImage = "https://lastfm.freetls.fastly.net/i/u/174s/1c8439b16ed4ca4e0bac727e7b325581.png",
        extraLargeImage = "https://lastfm.freetls.fastly.net/i/u/300x300/1c8439b16ed4ca4e0bac727e7b325581.png"
    )
}
