/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.repositories

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.kc.android.lastfm.data.local.LastFmDb
import com.kc.android.lastfm.data.local.entities.AlbumEntity
import com.kc.android.lastfm.data.local.entities.RemoteKeyEntity
import com.kc.android.lastfm.data.remote.dtos.mapper.toAlbumEntity
import com.kc.android.lastfm.data.remote.services.LastFmService
import retrofit2.HttpException
import java.io.IOException

/**
 * Label for
 */
private const val REMOTE_KEY_LABEL = "ALBUMS_KEY"

/**
 * Implementation of [RemoteMediator] to fetch new data from
 * remote source based on key.
 */
@OptIn(ExperimentalPagingApi::class)
class AlbumRemoteMediator(
    private val db: LastFmDb,
    private val service: LastFmService,
    private val searchString: String,
    private val pageSize: Int
) : RemoteMediator<Int, AlbumEntity>() {

    private val albumDao = db.albumDao()
    private val remoteKeyDao = db.remoteKeyDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, AlbumEntity>): MediatorResult {
        try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val remoteKey = remoteKeyDao.getByLabel(REMOTE_KEY_LABEL)
                        ?: return MediatorResult.Success(endOfPaginationReached = true)

                    remoteKey.nextKey
                }
            }
            val response = service.searchAlbumsBy(searchString, loadKey ?: 1, pageSize).body()
                ?: return MediatorResult.Error(IllegalStateException("response is null"))

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    remoteKeyDao.deleteByLabel(REMOTE_KEY_LABEL)
                    albumDao.deleteAll()
                }
                remoteKeyDao.insertOrReplace(RemoteKeyEntity(REMOTE_KEY_LABEL, response.results.query.page + 1))
                albumDao.insertAll(*response.results.albumMatches.albums.map { it.toAlbumEntity() }.toTypedArray())
            }

            // end of pagination reached when startIndex >= totalResults
            return MediatorResult.Success(endOfPaginationReached = response.results.startIndex >= response.results.totalResults)
        } catch (ioEx: IOException) {
            return MediatorResult.Error(ioEx)
        } catch (httpEx: HttpException) {
            return MediatorResult.Error(httpEx)
        }
    }
}
