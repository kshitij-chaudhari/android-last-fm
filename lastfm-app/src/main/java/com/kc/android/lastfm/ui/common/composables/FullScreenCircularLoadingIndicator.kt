/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.ui.common.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun Preview_FullScreenCircularLoadingIndicator() {
    FullScreenCircularLoadingIndicator()
}

/**
 * Full Screen reusable loading indicator
 */
@Composable
fun FullScreenCircularLoadingIndicator(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator()
    }
}
