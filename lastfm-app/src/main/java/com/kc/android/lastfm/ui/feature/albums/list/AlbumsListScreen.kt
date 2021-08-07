/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.ui.feature.albums.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.kc.android.lastfm.Destinations
import com.kc.android.lastfm.R
import com.kc.android.lastfm.ui.common.composables.FullScreenCircularLoadingIndicator
import com.kc.android.lastfm.ui.common.composables.SearchTextField
import com.kc.android.lastfm.ui.feature.albums.list.composable.AlbumListItem

/**
 * Composable to display Albums List Screen
 */
@Composable
fun AlbumsListScreen(
    navController: NavHostController,
    albumsListViewModel: AlbumsListViewModel
) {
    Scaffold(
        topBar = {
            Surface(elevation = 8.dp) {
                Box(
                    Modifier.padding(16.dp).background(MaterialTheme.colors.background).fillMaxWidth()
                ) {
                    var searchQuery by remember { mutableStateOf(TextFieldValue()) }
                    val focusManager = LocalFocusManager.current
                    SearchTextField(
                        value = searchQuery,
                        hint = stringResource(id = R.string.search_hint),
                        focusManager = focusManager,
                        onValueChange = { value -> searchQuery = value },
                        onClick = { albumsListViewModel.searchAlbums(searchQuery.text.trim()) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
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
}
