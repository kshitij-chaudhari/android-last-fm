/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.domain.repositories

import androidx.paging.PagingData
import com.kc.android.lastfm.domain.models.Album
import kotlinx.coroutines.flow.Flow

/**
 * Interface for the Album repository is stored here in
 * [lastfm-domain] module for easy faking.
 *
 */
interface AlbumRepository {
    /**
     * Fetch Albums. The domain layer doesn't know the actual implementation details.
     * Its up-to the data layer to define the implementation and decide how it wants to source the data.
     *
     * @param searchString search query for the expected list of [Album]
     * @param pageSize define the number of items to be return at a given time. This is controlled
     * by UI, since it depends on the amount of data UI needs to show at a given time.
     */
    fun fetchAlbums(searchString: String, pageSize: Int): Flow<PagingData<Album>>
}
