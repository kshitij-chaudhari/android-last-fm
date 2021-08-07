/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.domain.interactors

import com.kc.android.lastfm.domain.repositories.AlbumRepository
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

class AlbumUseCaseImplTest {

    @RelaxedMockK lateinit var repository: AlbumRepository

    @Before fun setUp() = MockKAnnotations.init(this)
    @After fun tearDown() = clearAllMocks()

    /**
     * Verify [AlbumUseCase.fetchAlbums] delegates request to
     * repository with the same parameters.
     */
    @Test
    fun `test-fetchAlbums-delegates-to-repository`() {
        val albumUseCase = AlbumUseCaseImpl(repository)
        albumUseCase.fetchAlbums("search-string", 10)

        verify { repository.fetchAlbums("search-string", 10) }
    }
}
