/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.remote.services

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import java.lang.IllegalStateException
import java.nio.charset.StandardCharsets

/**
 * Extension methof fot [MockWebServer] to read json from resource folder.
 *
 */
internal fun MockWebServer.enqueue(responseJsonPath: String, code: Int) {
    javaClass.classLoader?.getResourceAsStream(responseJsonPath)?.use {
        val source = it.source().buffer()
        enqueue(
            MockResponse()
                .setBody(source.readString(StandardCharsets.UTF_8))
                .setResponseCode(code)
        )
    } ?: throw IllegalStateException("Not able to read file $responseJsonPath")
}
