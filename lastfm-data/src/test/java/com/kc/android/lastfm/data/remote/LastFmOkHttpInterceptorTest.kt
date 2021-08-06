/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.remote

import com.kc.android.lastfm.data.remote.services.LastFmService
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Builder
import okhttp3.Interceptor
import okhttp3.Request
import org.junit.After
import org.junit.Before
import org.junit.Test

class LastFmOkHttpInterceptorTest {
    @RelaxedMockK lateinit var interceptorChain: Interceptor.Chain
    @RelaxedMockK lateinit var request: Request
    @RelaxedMockK lateinit var httpUrl: HttpUrl
    @RelaxedMockK lateinit var builder: Builder
    lateinit var lastFmOkHttpInterceptor: LastFmOkHttpInterceptor
    private val dummyApiKey = "dummy-api-key"

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        lastFmOkHttpInterceptor = LastFmOkHttpInterceptor(dummyApiKey)
    }

    @After
    fun tearDown() = clearAllMocks()

    /**
     * Here we are verifying if the `api_key` query parameter is passed properly in interceptor.
     * In order to ensure `api_key` parameter does not get accidentally changed by someone,
     * we are hard-coding the parameter in below test instead of using from [LastFmService.API_KEY_PARAM]
     */
    @Test
    fun `test-api-key-added-as-query-parameter`() {
        every { interceptorChain.request() } returns request
        every { request.url } returns httpUrl
        every { httpUrl.newBuilder() } returns builder

        lastFmOkHttpInterceptor.intercept(interceptorChain)

        verify { builder.addQueryParameter("api_key", dummyApiKey) }
    }
}
