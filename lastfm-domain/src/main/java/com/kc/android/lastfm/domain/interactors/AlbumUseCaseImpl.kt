/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.domain.interactors

import com.kc.android.lastfm.domain.repositories.AlbumRepository
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
}
