/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.ui.feature.albums.list

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.kc.android.lastfm.ui.common.composables.FullScreenCircularLoadingIndicator

/**
 * Composable to display Albums List Screen
 */
@Composable
fun AlbumsListScreen(
    albumsListViewModel: AlbumsListViewModel = hiltViewModel()
) {
    val albums = albumsListViewModel.albums.collectAsLazyPagingItems()
    val context = LocalContext.current
    if (albums.itemCount == 0) {
        FullScreenCircularLoadingIndicator()
    } else {
        LazyColumn {
            items(albums) { album ->
                album?.let {
                    AlbumListItem(
                        album = album,
                        onClick = {
                            Toast.makeText(context, album.name, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}
