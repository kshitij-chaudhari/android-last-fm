/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.remote.services

import com.kc.android.lastfm.data.remote.dtos.AlbumSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Service to interact with Last Fm remote apis.
 */
interface LastFmService {
    companion object {
        const val BASE_URL = "https://ws.audioscrobbler.com/2.0/"
        const val API_KEY_PARAM = "api_key"
        const val ALBUM_PARAM = "album"
        const val PAGE_PARAM = "page"
        const val LIMIT_PARAM = "limit"
    }

    /**
     * Query to fetch albums by [searchString], [page] and [pageSize].
     */
    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("?method=album.search&format=json")
    suspend fun searchAlbumsBy(
        @Query(ALBUM_PARAM) searchString: String,
        @Query(PAGE_PARAM) page: Int,
        @Query(LIMIT_PARAM) pageSize: Int
    ): Response<AlbumSearchResponse>
}
