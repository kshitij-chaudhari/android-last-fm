/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.domain.interactors

import androidx.paging.PagingData
import com.kc.android.lastfm.domain.models.Album
import kotlinx.coroutines.flow.Flow

/**
 * Use-Case Interface is exposed to the UI layer and conceptually the single entry point
 * for UI to interact with data layer.
 * In this class [fetchAlbums]  is exposed so UI layer can fetch the necessary albums needed.
 */
interface AlbumUseCase {
    fun fetchAlbums(searchString: String, pageSize: Int): Flow<PagingData<Album>>
}
