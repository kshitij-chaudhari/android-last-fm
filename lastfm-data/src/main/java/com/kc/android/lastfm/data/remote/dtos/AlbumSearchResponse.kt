/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.remote.dtos

import com.google.gson.annotations.SerializedName

/**
 * Last Fm response is not very mobile friendly and too verbose.
 * There are couple of options to handle such case
 * 1) Using Dtos that map exactly with response
 * 2) Using some implementation of [retrofit2.Converter.Factory] to parse response manually.
 *
 * The approach taken in this sample is to map response exactly using multiple Dtos
 */
data class AlbumSearchResponse(val results: ResultsDto)

data class ResultsDto(
    @SerializedName("opensearch:Query") val query: QueryDto,
    @SerializedName("albummatches") val albumMatches: AlbumMatchesDto,
)

data class QueryDto(@SerializedName("startPage") val page: Int)

data class AlbumMatchesDto(@SerializedName("album") val albums: List<AlbumDto>)

data class AlbumDto(
    val mbid: String,
    val name: String,
    val artist: String,
    val url: String,
    val image: List<ImageDto>
)

data class ImageDto(
    @SerializedName("#text") val url: String,
    val size: String
)
