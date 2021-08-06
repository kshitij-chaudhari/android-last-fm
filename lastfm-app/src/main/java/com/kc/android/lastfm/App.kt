/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.lastfm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Need to create a custom [Application] class to initialise [HiltAndroidApp]
 */
@HiltAndroidApp
class App : Application()
