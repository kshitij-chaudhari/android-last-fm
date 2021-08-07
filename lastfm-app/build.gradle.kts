import com.kc.android.lastfm.App
import com.kc.android.lastfm.Libs

plugins {
    id("com.android.application")
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
        versionCode = App.versionCode
        versionName = App.versionName
        applicationId = App.applicationId

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "LASTFM_API_KEY", "\"${project.property("LASTFM_API_KEY")}\"")
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

    kotlinOptions {
        allWarningsAsErrors = true
        jvmTarget = JavaVersion.VERSION_11.toString()

        // Enable using experimental APIs
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.version
    }
}

dependencies {
    // modules
    implementation(project(path = ":lastfm-domain"))
    implementation(project(path = ":lastfm-data"))

    implementation(Libs.Google.material)

    // androidx
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.lifecycleRuntimeKtx)

    // compose
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.uiTooling)
    implementation(Libs.AndroidX.Compose.uiToolingPreview)
    implementation(Libs.AndroidX.Compose.foundation)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.lifecycleViewModelCompose)
    implementation(Libs.AndroidX.Compose.activityCompose)
    implementation(Libs.AndroidX.Compose.pagingCompose)
    implementation(Libs.AndroidX.Compose.navigationCompose)
    implementation(Libs.AndroidX.Compose.hiltNavigationCompose)

    // hilt
    implementation(Libs.Google.Hilt.android)
    kapt(Libs.Google.Hilt.compiler)
}
