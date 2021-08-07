/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.data.remote.entities.mapper

import com.google.common.truth.Truth.assertThat
import com.kc.android.lastfm.data.fake.FakeAlbumDtos
import com.kc.android.lastfm.data.fake.FakeAlbumEntities
import com.kc.android.lastfm.data.remote.dtos.mapper.toAlbumEntity
import org.junit.Test

class AlbumDtoMapperTest {
    /**
     * Verify [com.kc.android.lastfm.data.remote.dtos.AlbumDto.toAlbumEntity] maps
     * to [com.kc.android.lastfm.data.local.entities.AlbumEntity] as expected.
     */
    @Test
    fun `test-AlbumDto-to-AlbumEntity-mapping`() {
        val expected = FakeAlbumEntities.believe(0)
        val actual = FakeAlbumDtos.believe.toAlbumEntity()

        assertThat(actual).isEqualTo(expected)
    }
}
