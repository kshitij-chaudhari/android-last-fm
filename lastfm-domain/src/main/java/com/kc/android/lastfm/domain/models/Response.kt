/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.domain.models

sealed class Response<out DATA> {
    data class Loading<out DATA>(val data: DATA? = null) : Response<DATA>()
    data class Success<out DATA>(val data: DATA) : Response<DATA>()
    data class Error<out DATA>(val error: Throwable, val data: DATA? = null) : Response<DATA>()
}
