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

            // compose support for other jetpack components
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-rc01"
            const val pagingCompose = "androidx.paging:paging-compose:1.0.0-alpha11"
        }

        object Room {
            const val version = "2.3.0"
            const val roomRuntime = "androidx.room:room-runtime:$version"
            const val roomCompiler = "androidx.room:room-compiler:$version"
            const val roomKtx = "androidx.room:room-ktx:$version"

            const val testing = "androidx.room:room-testing:$version"
        }

        object Paging {
            const val version = "3.0.0"
            const val pagingRuntime = "androidx.paging:paging-runtime-ktx:$version"
            const val pagingCommon = "androidx.paging:paging-common:$version"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:1.4.0"

        object Hilt {
            const val version = "2.37"
            const val compiler = "com.google.dagger:hilt-compiler:$version"

            const val android = "com.google.dagger:hilt-android:$version"
            const val androidTesting = "com.google.dagger:hilt-android-testing:$version"
        }
    }

    object OkHttp3 {
        const val version = "4.9.1"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$version"
    }

    object Retrofit2 {
        const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val androidxJunitKtx = "androidx.test.ext:junit-ktx:1.1.3"

        const val testCoreKtx = "androidx.test:core-ktx:1.4.0"
        const val archCoreTesting = "androidx.arch.core:core-testing:2.1.0"

        const val truth = "com.google.truth:truth:1.1.3"
        const val mockk = "io.mockk:mockk:1.12.0"
        const val robolectric = "org.robolectric:robolectric:4.6.1"
    }

    object KtLint {
        const val version = "0.40.0"
        const val ktLint = "com.pinterest:ktlint:$version"
    }
}