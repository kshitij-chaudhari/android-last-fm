/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.domain.interactors

import com.kc.android.lastfm.domain.models.Album
import com.kc.android.lastfm.domain.models.Response
import com.kc.android.lastfm.domain.repositories.AlbumRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Implementation of [AlbumUseCase].
 */
class AlbumUseCaseImpl @Inject constructor(private val repository: AlbumRepository) : AlbumUseCase {

    /**
     * Delegates request to [com.kc.android.lastfm.domain.repositories.AlbumRepository] to fetch the albums.
     */
    override fun fetchAlbums(searchString: String, pageSize: Int) =
        repository.fetchAlbums(searchString, pageSize)

    override fun fetchAlbum(id: Int): Flow<Response<Album?>> =
        repository.fetchAlbum(id)
}
