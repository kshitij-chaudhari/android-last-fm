/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.ui.common.composables

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kc.android.lastfm.AppActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Tests for [HeaderText]
 *
 * The class demonstrates tests for Composables. In this sample, Composables are tested
 * using androidTest which needs to be ran on device. The same could be moved to Robolectric Unit tests.
 */
@RunWith(AndroidJUnit4::class)
class HeaderTextTest {
    @get:Rule val composeTestRule = createAndroidComposeRule<AppActivity>()

    /**
     * Test that text is actually displayed on UI with the passed string.
     */
    @Test
    fun `test-text-displayed`() {
        val expectedTest = "This is header test"
        composeTestRule.setContent {
            HeaderText(text = expectedTest)
        }

        // by asserting the text exists, we verify that that text is displayed on UI
        composeTestRule.onNodeWithText(expectedTest).assertExists()
    }
}
