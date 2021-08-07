/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm.ui.feature.albums.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kc.android.lastfm.domain.interactors.AlbumUseCase
import com.kc.android.lastfm.domain.models.Album
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for [AlbumsListScreen] to handle all the UI logic and data interactions.
 */
@HiltViewModel
class AlbumsListViewModel @Inject constructor(
    application: Application,
    private val albumUseCase: AlbumUseCase
) : AndroidViewModel(application) {

    /**
     * Fetch flow of paginated albums from data layer.
     */
    private val _albums: MutableStateFlow<PagingData<Album>> = MutableStateFlow(PagingData.empty())
    val albums = _albums.asStateFlow()

    init {
        // on initial load, setting the searchString to some arbitrary value to load some data.
        searchAlbums(searchString = "a")
    }

    fun searchAlbums(searchString: String) {
        if (searchString.isNotBlank()) { // skip searching for blank
            viewModelScope.launch {
                // delay and resetting to empty to demonstrate loading spinner is shown between searches
                _albums.value = PagingData.empty()
                delay(750)
                albumUseCase.fetchAlbums(searchString = searchString, pageSize = 50).cachedIn(viewModelScope).collect {
                    _albums.value = it
                }
            }
        }
    }
}
