/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.kc.android.lastfm.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main and only [android.app.Activity].
 * The job of [AppActivity] is to set the [AppTheme] and to initiate the
 * compose flow using [NavGraph].
 */
@AndroidEntryPoint
class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavGraph(navController)
                }
            }
        }
    }
}
