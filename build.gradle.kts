plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.zipline.gradle.plugin) apply false
    alias(libs.plugins.spotless.gradle.plugin) apply true
}

spotless {
    predeclareDeps()
}

extensions.configure<com.diffplug.gradle.spotless.SpotlessExtensionPredeclare> {
    kotlin {
        ktlint("0.49.1")
    }
}