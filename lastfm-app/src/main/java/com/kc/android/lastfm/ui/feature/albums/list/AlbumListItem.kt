/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.ui.feature.albums.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kc.android.lastfm.domain.models.Album
import com.kc.android.lastfm.ui.common.composables.HeaderText
import com.kc.android.lastfm.ui.previewitems.PreviewAlbum

@Preview
@Composable
fun Preview_AlbumListItem() {
    AlbumListItem(album = PreviewAlbum.believe(), onClick = {})
}
/**
 * Composable to define the layout of a list item.
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AlbumListItem(
    modifier: Modifier = Modifier,
    album: Album,
    onClick: (Album) -> Unit,
    elevation: Dp = 4.dp,
    color: Color = MaterialTheme.colors.surface,
    shape: Shape = RoundedCornerShape(8.dp),
) {
    Surface(
        elevation = elevation,
        color = color,
        modifier = modifier
            .padding(16.dp, 8.dp, 16.dp, 8.dp),
        shape = shape,
        onClick = { onClick(album) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            HeaderText(text = album.name)
            Text(text = album.artist)
        }
    }
}
