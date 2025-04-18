// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.roborazzi) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    // Plugins for Project
    alias(libs.plugins.jo.application.compose) apply false
    alias(libs.plugins.jo.android.library.compose) apply false
    alias(libs.plugins.jo.feature) apply false
    alias(libs.plugins.jo.hilt) apply false
    alias(libs.plugins.jo.room) apply false
}