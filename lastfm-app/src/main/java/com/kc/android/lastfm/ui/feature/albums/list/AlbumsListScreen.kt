/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.ui.feature.albums.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.kc.android.lastfm.Destinations
import com.kc.android.lastfm.ui.common.composables.FullScreenCircularLoadingIndicator
import com.kc.android.lastfm.ui.feature.albums.list.composable.AlbumListItem

/**
 * Composable to display Albums List Screen
 */
@Composable
fun AlbumsListScreen(
    navController: NavHostController,
    albumsListViewModel: AlbumsListViewModel
) {
    val albums = albumsListViewModel.albums.collectAsLazyPagingItems()
    if (albums.itemCount == 0) {
        FullScreenCircularLoadingIndicator()
    } else {
        LazyColumn {
            items(albums) { album ->
                album?.let {
                    AlbumListItem(
                        album = album,
                        onClick = {
                            navController.navigate("${Destinations.AlbumDetailsScreen.route}/${album.id}")
                        }
                    )
                }
            }
        }
    }
}
