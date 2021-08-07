/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.ui.feature.albums.details.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter

@Preview
@Composable
fun Preview_ListThumbnailImage() {
    DetailsTopImage(imagePath = "https://lastfm.freetls.fastly.net/i/u/64s/1c8439b16ed4ca4e0bac727e7b325581.png")
}

@Composable
fun DetailsTopImage(
    modifier: Modifier = Modifier,
    imagePath: String,
    contentDescription: String? = null
) {
    Image(
        contentScale = ContentScale.Crop,
        painter = rememberCoilPainter(
            request = imagePath,
            fadeIn = true,
            fadeInDurationMs = 250
        ),
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.50f),
        contentDescription = contentDescription
    )
}
