/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Remote key used to store reference of next-key for given label
 */
@Entity(tableName = "remote_keys")
data class RemoteKeyEntity(
    @PrimaryKey val label: String,
    val nextKey: Int?
)
