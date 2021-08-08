/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.ui.feature.albums.list.composable

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kc.android.lastfm.AppActivity
import com.kc.android.lastfm.ui.previewitems.PreviewAlbum
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Tests for [AlbumListItem]
 *
 * The class demonstrates tests for Composables. In this sample, Composables are tested
 * using androidTest which needs to be ran on device. The same could be moved to Robolectric Unit tests.
 */
@RunWith(AndroidJUnit4::class)
class AlbumListItemTest {
    @get:Rule val composeTestRule = createAndroidComposeRule<AppActivity>()

    /**
     * Test that required contents from album is displayed
     */
    @Test
    fun `test-album-displayed-on-list-item`() {
        val album = PreviewAlbum.believe(0)

        composeTestRule.setContent {
            AlbumListItem(album = album, onClick = {})
        }

        composeTestRule.onNodeWithText(album.name).assertExists()
        composeTestRule.onNodeWithText(album.artist).assertExists()
    }
}
