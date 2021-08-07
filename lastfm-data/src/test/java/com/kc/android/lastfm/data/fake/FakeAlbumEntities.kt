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
}
