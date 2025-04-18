plugins {
    alias(libs.plugins.jo.application.compose)
    alias(libs.plugins.jo.hilt)
}

android {
    namespace = "com.jo.laftelclone"

    defaultConfig {
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level
    }
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.feature.splash)
    implementation(projects.feature.main)
    implementation(projects.feature.login)
}