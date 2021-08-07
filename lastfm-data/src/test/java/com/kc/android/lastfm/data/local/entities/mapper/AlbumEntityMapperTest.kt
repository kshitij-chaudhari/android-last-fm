/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.local.entities.mapper

import com.google.common.truth.Truth
import com.kc.android.lastfm.data.fake.FakeAlbum
import com.kc.android.lastfm.data.fake.FakeAlbumEntities
import org.junit.Test

class AlbumEntityMapperTest {
    /**
     * Verify [com.kc.android.lastfm.data.local.entities.AlbumEntity.toAlbum] maps
     * to [com.kc.android.lastfm.domain.models.Album] as expected.
     */
    @Test
    fun `test-AlbumEntity-to-Album-mapping`() {
        val expected = FakeAlbum.believe(1)
        val actual = FakeAlbumEntities.believe(1).toAlbum()

        Truth.assertThat(actual).isEqualTo(expected)
    }
}
