/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.repositories

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import com.kc.android.lastfm.data.local.LastFmDb
import com.kc.android.lastfm.data.local.entities.mapper.toAlbum
import com.kc.android.lastfm.data.remote.services.LastFmService
import com.kc.android.lastfm.domain.models.Album
import com.kc.android.lastfm.domain.models.Response
import com.kc.android.lastfm.domain.repositories.AlbumRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Implementation of [AlbumRepository].
 *
 * Since paginated data is expected, [Pager] is use along
 * with [androidx.paging.RemoteMediator].
 */
@OptIn(ExperimentalPagingApi::class)
class AlbumRepositoryImpl @Inject constructor(
    private val db: LastFmDb,
    private val service: LastFmService
) : AlbumRepository {
    private val albumDao = db.albumDao()

    /**
     * [com.kc.android.lastfm.data.local.daos.AlbumDao.getPaginated] is used as Single-source-of-truth.
     * [AlbumRemoteMediator] is used to fetch data from remote service.
     */
    override fun fetchAlbums(searchString: String, pageSize: Int) = Pager(
        config = PagingConfig(pageSize),
        remoteMediator = AlbumRemoteMediator(db, service, searchString, pageSize)
    ) {
        albumDao.getPaginated()
    }.flow.map { pagingData -> pagingData.map { albumEntity -> albumEntity.toAlbum() } }

    /**
     * Since the current remote api does not provide any
     * useful information, [Album] is only fetched from local-db
     * in the sample app.
     */
    override fun fetchAlbum(id: Int): Flow<Response<Album?>> = networkBoundResource(
        query = { db.albumDao().get(id).map { it.toAlbum() } },
        fetch = { /* not needed for sample */ },
        saveFetchResult = { /* not needed for sample */ },
        shouldFetch = { false }
    )
}
