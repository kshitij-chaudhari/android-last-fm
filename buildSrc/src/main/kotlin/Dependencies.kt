package com.kc.android.lastfm

object App {
    const val compileSdk = 30
    const val versionCode = 1
    const val versionName = "1.0"
    const val applicationId = "com.kc.android.lastfm"
    const val minSdkVersion = 28
    const val targetSdkVersion = 30
}

object Libs {
    const val buildToolsVersion = "30.0.3"

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.10"

        object Coroutines {
            const val version = "1.5.0"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.6.0"
        const val appcompat = "androidx.appcompat:appcompat:1.4.0-alpha03"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha01"

        object Compose {
            const val version = "1.0.0"

            const val ui = "androidx.compose.ui:ui:$version"
            const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
            const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val material = "androidx.compose.material:material:$version"
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-rc01"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:1.4.0"
    }

    object KtLint {
        const val version = "0.40.0"
        const val ktLint = "com.pinterest:ktlint:$version"
    }
}