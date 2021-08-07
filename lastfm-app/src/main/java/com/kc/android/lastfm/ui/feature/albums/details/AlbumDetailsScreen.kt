package com.kc.android.lastfm.ui.feature.albums.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import com.kc.android.lastfm.domain.models.Album
import com.kc.android.lastfm.domain.models.Response
import com.kc.android.lastfm.ui.common.composables.FullScreenCircularLoadingIndicator
import com.kc.android.lastfm.ui.common.composables.HeaderText
import com.kc.android.lastfm.ui.feature.albums.details.composable.DetailsTopImage

/**
 * Composable to display Album Details Screen
 */
@Composable
fun AlbumDetailsScreen(albumDetailsViewModel: AlbumDetailsViewModel) {
    // Flow needs to be collected using [Flow#flowWithLifecycle] to ensure that producer is cancelled when the
    // app moves in background.
    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycleAwareFlow = remember(albumDetailsViewModel.album, lifecycleOwner) {
        albumDetailsViewModel.album.flowWithLifecycle(
            lifecycleOwner.lifecycle,
            Lifecycle.State.STARTED
        )
    }

    val response by lifecycleAwareFlow.collectAsState(Response.Loading())
    when (response) {
        is Response.Success<Album?> -> {
            val album = (response as Response.Success<Album?>).data
            album?.let {
                Column {
                    //try to get first non-null high quality image
                    getImageUrl(album)?.let {
                        DetailsTopImage(imagePath = album.largeImage ?:album.mediumImage?:"")
                    }

                    // Note: below could be moved out to custom composables, but not done in the sample
                    Spacer(modifier = Modifier.height(16.dp))
                    HeaderText(
                        text = album.name,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = album.artist,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    )
                }
            }
        }
        else -> {
            FullScreenCircularLoadingIndicator()
        }
    }
}

/**
 * Helper method to imageUrl with highest resolution as preference.
 */
fun getImageUrl(album:Album) : String? {
    return if(!album.largeImage.isNullOrEmpty()) album.largeImage
    else if(!album.mediumImage.isNullOrEmpty()) album.mediumImage
    else if(!album.smallImage.isNullOrEmpty()) album.smallImage
    else null
}