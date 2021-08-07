/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.remote.services

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.kc.android.lastfm.data.di.FAKE_API_KEY
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
class LastFmServiceTest {
    @get:Rule(order = 0) val hiltRule = HiltAndroidRule(this)
    @get:Rule(order = 1) val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject lateinit var okHttpClient: OkHttpClient

    private lateinit var mockServer: MockWebServer
    private lateinit var lastFmService: LastFmService

    /**
     * Setup does following
     * 1) Initialise Hilt injection to inject dependencies.
     * 2) Create a [MockWebServer] with base_url of "/".
     * 3) Create [Retrofit] using [MockWebServer]
     * 4) Create an instance of [LastFmService]
     */
    @Before
    fun setUp() {
        hiltRule.inject()

        mockServer = MockWebServer()
        mockServer.start()

        val retrofit = Retrofit.Builder()
            .baseUrl(mockServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        lastFmService = retrofit.create(LastFmService::class.java)
    }

    @After
    fun tearDown() {
        mockServer.shutdown()
    }

    /**
     * Test [LastFmService#searchAlbumsBy] returns non-null response
     */
    @Test
    fun `test-searchAlbumsBy-returns-non-null-response`() {
        mockServer.enqueue("album_search_believe.json", 200)

        runBlocking {
            val response = lastFmService.searchAlbumsBy("believe", 1, 10)
            assertThat(response).isNotNull()
            assertThat(response.body()).isNotNull()
        }
    }

    /**
     * Test [LastFmService#searchAlbumsBy] is parsed properly.
     * This will tests the entire [Retrofit] layer from querying to parsing.
     */
    @Test
    fun `test-searchAlbumsBy-is-parsed-properly`() {
        mockServer.enqueue("album_search_believe.json", 200)

        runBlocking {
            val response = lastFmService.searchAlbumsBy("believe", 1, 10)

            // verify page index
            assertThat(response.body()?.results?.query?.page).isEqualTo(1)

            // verify number of albums
            assertThat(response.body()?.results?.albumMatches?.albums?.size).isEqualTo(3)

            // verify album content
            val actualAlbum = response.body()?.results?.albumMatches?.albums?.get(0)
            assertThat(actualAlbum?.mbid).isEqualTo("c559efc2-f734-41ae-93bd-2d78414e0356")
            assertThat(actualAlbum?.name).isEqualTo("Believe")
            assertThat(actualAlbum?.artist).isEqualTo("Disturbed")
            assertThat(actualAlbum?.url).isEqualTo("https://www.last.fm/music/Disturbed/Believe")

            // verify album images
            assertThat(actualAlbum?.image?.size).isEqualTo(4)
            assertThat(actualAlbum?.image?.get(0)?.url).isEqualTo("https://lastfm.freetls.fastly.net/i/u/34s/dcf5cf4b9da64e979719a102acd222cc.png")
            assertThat(actualAlbum?.image?.get(0)?.size).isEqualTo("small")
        }
    }

    /**
     * Test [LastFmService#searchAlbumsBy] request url
     */
    @Test
    fun `test-searchAlbumsBy-has-correct-path`() {
        mockServer.enqueue("album_search_believe.json", 200)

        runBlocking {
            val searchString = "believe"
            lastFmService.searchAlbumsBy(searchString, 1, 10)
            assertThat(mockServer.takeRequest().path).isEqualTo("/?method=album.search&format=json&album=$searchString&page=1&limit=10&api_key=$FAKE_API_KEY")
        }
    }
}
