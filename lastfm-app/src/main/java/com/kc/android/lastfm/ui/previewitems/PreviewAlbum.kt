/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.ui.previewitems

import com.kc.android.lastfm.domain.models.Album

/**
 * Fake [Album] instances for testing and preview.
 */
object PreviewAlbum {
    fun believe(id: Int = 0) = Album(
        id = id,
        mbid = "c559efc2-f734-41ae-93bd-2d78414e0356",
        name = "Believe",
        artist = "Disturbed",
        url = "https://www.last.fm/music/Disturbed/Believe",
        smallImage = "https://lastfm.freetls.fastly.net/i/u/34s/dcf5cf4b9da64e979719a102acd222cc.png",
        mediumImage = "https://lastfm.freetls.fastly.net/i/u/64s/dcf5cf4b9da64e979719a102acd222cc.png",
        largeImage = "https://lastfm.freetls.fastly.net/i/u/174s/dcf5cf4b9da64e979719a102acd222cc.png"
    )
}
