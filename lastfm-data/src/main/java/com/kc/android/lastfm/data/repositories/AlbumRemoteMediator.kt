/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.repositories

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.kc.android.lastfm.data.local.LastFmDb
import com.kc.android.lastfm.data.local.entities.AlbumEntity
import com.kc.android.lastfm.data.remote.services.LastFmService

/**
 * Implementation of [RemoteMediator] to fetch new data from
 * remote source based on key.
 */
@OptIn(ExperimentalPagingApi::class)
class AlbumRemoteMediator(
    private val db: LastFmDb,
    private val service: LastFmService
) : RemoteMediator<Int, AlbumEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, AlbumEntity>
    ): MediatorResult {
        TODO("Not yet implemented")
    }
}
