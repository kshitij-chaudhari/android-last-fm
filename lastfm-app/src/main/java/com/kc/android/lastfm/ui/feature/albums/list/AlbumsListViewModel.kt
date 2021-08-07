/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.ui.feature.albums.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.kc.android.lastfm.domain.interactors.AlbumUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel for [AlbumsListScreen] to handle all the UI logic and data interactions.
 */
@HiltViewModel
class AlbumsListViewModel @Inject constructor(
    application: Application,
    albumUseCase: AlbumUseCase
) : AndroidViewModel(application) {

    /**
     * Fetch flow of paginated albums from data layer.
     */
    val albums = albumUseCase.fetchAlbums("Master of My Make-Believe (Deluxe Edition)", pageSize = 50)
}
