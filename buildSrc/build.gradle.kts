plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

/**
 * Plugins used in the application are defined here so they could be managed at one place.
 */
object Plugins {
    object Versions {
        const val android = "7.1.0-alpha04"
        const val kotlin = "1.5.10"
        const val spotless = "5.11.1"
    }
    const val android = "com.android.tools.build:gradle:${Versions.android}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val spotless = "com.diffplug.spotless:spotless-plugin-gradle:${Versions.spotless}"
}

dependencies {
    implementation(Plugins.android)
    implementation(Plugins.kotlin)
    implementation(Plugins.spotless)
}