/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kc.android.lastfm.ui.feature.albums.details.AlbumDetailsScreen
import com.kc.android.lastfm.ui.feature.albums.details.AlbumDetailsViewModel
import com.kc.android.lastfm.ui.feature.albums.list.AlbumsListScreen
import com.kc.android.lastfm.ui.feature.albums.list.AlbumsListViewModel

/**
 * All the routes in the application are defined under the [Destinations] sealed class.
 * [Destinations] should be used whenever screen needs to navigate to another destination.
 */
sealed class Destinations(val route: String) {
    object AlbumsListScreen : Destinations("albums-list-screen-route")
    object AlbumDetailsScreen : Destinations("album-details-screen-route")
}

/**
 * Navigation graph of the application is defined here.
 */
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destinations.AlbumsListScreen.route
    ) {

        composable(Destinations.AlbumsListScreen.route) {
            val albumsListViewModel = hiltViewModel<AlbumsListViewModel>()
            AlbumsListScreen(navController, albumsListViewModel)
        }

        composable("${Destinations.AlbumDetailsScreen.route}/{albumId}") {
            val albumDetailsViewModel = hiltViewModel<AlbumDetailsViewModel>()
            AlbumDetailsScreen(albumDetailsViewModel)
        }
    }
}
