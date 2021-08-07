/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.domain.models

/**
 * Model representation of Album.
 *
 * Only Model classes will be used in rendering the UI
 * as UI should not be aware of DB Entities and Network Dtos.
 *
 * Also using Model classes allow us to flatten the verbose Dto objects.
 */
data class Album(
    val id: Int,
    val mbid: String,
    val name: String,
    val artist: String,
    val url: String,
    val smallImage: String?,
    val mediumImage: String?,
    val largeImage: String?,
    val extraLargeImage: String?
)
