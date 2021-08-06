/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.remote

import com.kc.android.lastfm.data.remote.services.LastFmService.Companion.API_KEY_PARAM
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Custom [Interceptor] to inject Last FM api key as query parameter for every network request.
 */

class LastFmOkHttpInterceptor(private val lastFmApiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val httpUrl = chain.request().url.newBuilder()
            .addQueryParameter(API_KEY_PARAM, lastFmApiKey)
            .build()

        // create a new request with the additional query parameter
        val newRequest = chain.request().newBuilder()
            .url(httpUrl).build()

        return chain.proceed(newRequest)
    }
}
