import com.kc.android.lastfm.Libs
plugins {
    id("com.diffplug.spotless")
}

spotless {
    kotlin {
        target("**/*.kt")
        targetExclude("**/build/**/*.kt")
        targetExclude("**/bin/**/*.kt")

        ktlint(Libs.KtLint.version)
        licenseHeaderFile(File("${rootDir.absolutePath}/spotless/copyright.kt"))
    }

    kotlinGradle {
        target("**/*.gradle.kts") // default target for kotlinGradle
        ktlint(Libs.KtLint.version)
    }

    format("xml") {
        target("**/res/**/*.xml")
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    }
}