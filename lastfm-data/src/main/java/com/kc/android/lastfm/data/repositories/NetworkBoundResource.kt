/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.repositories

import android.util.Log
import com.kc.android.lastfm.domain.models.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

/**
 * Concept based on NetworkBoundResource from google samples - https://bit.ly/2Vh9xJT
 */
inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
): Flow<Response<ResultType>> = flow {
    val localData = query().first()

    if (shouldFetch(localData)) {
        emit(Response.Loading(localData))

        try {
            saveFetchResult(fetch())
            emitAll(query().map { Response.Success(it) })
        } catch (throwable: Throwable) {
            Log.e(this::class.simpleName, throwable.message, throwable)
            emitAll(query().map { Response.Error(throwable, it) })
        }
    } else {
        emitAll(query().map { Response.Success(it) })
    }
}.flowOn(Dispatchers.IO)
