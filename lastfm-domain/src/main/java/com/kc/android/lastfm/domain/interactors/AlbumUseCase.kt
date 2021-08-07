/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.domain.interactors

import androidx.paging.PagingData
import com.kc.android.lastfm.domain.models.Album
import com.kc.android.lastfm.domain.models.Response
import kotlinx.coroutines.flow.Flow

/**
 * Use-Case Interface is exposed to the UI layer and conceptually the single entry point
 * for UI to interact with data layer.
 */
interface AlbumUseCase {
    /**
     * Fetch paginated list of albums from data layer.
     */
    fun fetchAlbums(searchString: String, pageSize: Int): Flow<PagingData<Album>>

    /**
     * Fetch a single [Album] from data layer by [Album.id]
     */
    fun fetchAlbum(id: Int): Flow<Response<Album?>>
}
