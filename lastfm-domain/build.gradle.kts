import com.kc.android.lastfm.App
import com.kc.android.lastfm.Libs

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = App.compileSdk
    buildToolsVersion = Libs.buildToolsVersion

    defaultConfig {
        minSdk = App.minSdkVersion
        targetSdk = App.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        allWarningsAsErrors = true
        jvmTarget = JavaVersion.VERSION_11.toString()

        // Enable using experimental APIs
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    // androidx
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appcompat)

    // paging
    implementation(Libs.AndroidX.Paging.pagingRuntime)

    // coroutines
    implementation(Libs.Kotlin.Coroutines.core)
    implementation(Libs.Kotlin.Coroutines.android)

    // hilt
    implementation(Libs.Google.Hilt.android)
    kapt(Libs.Google.Hilt.compiler)

    // test
    testImplementation(Libs.Test.testCoreKtx)
    testImplementation(Libs.Test.archCoreTesting)
    testImplementation(Libs.Test.junit)
    testImplementation(Libs.Test.androidxJunitKtx)
    testImplementation(Libs.Test.mockk)
    testImplementation(Libs.Test.truth)
}
