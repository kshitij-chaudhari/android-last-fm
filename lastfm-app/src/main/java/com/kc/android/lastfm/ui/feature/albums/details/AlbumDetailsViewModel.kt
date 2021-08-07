/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.ui.feature.albums.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.kc.android.lastfm.domain.interactors.AlbumUseCase
import com.kc.android.lastfm.domain.models.Album
import com.kc.android.lastfm.domain.models.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for [AlbumDetailsScreen] to handle all the UI logic and data interactions.
 */
@HiltViewModel
class AlbumDetailsViewModel @Inject constructor(
    application: Application,
    savedStateHandle: SavedStateHandle,
    albumUseCase: AlbumUseCase
) : AndroidViewModel(application) {

    private val albumId: Int = savedStateHandle.get<String>("albumId")?.toInt() ?: 0

    private val _album: MutableStateFlow<Response<Album?>> = MutableStateFlow(Response.Loading())
    val album = _album.asStateFlow()

    init {
        viewModelScope.launch {
            albumUseCase.fetchAlbum(albumId).collect {
                // delay to demonstrate loading spinner is shown before the actual data loads
                delay(750)
                _album.value = it
            }
        }
    }
}
