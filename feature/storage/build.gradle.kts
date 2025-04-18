plugins {
    alias(libs.plugins.jo.feature)
    alias(libs.plugins.jo.hilt)
}

android {
    namespace = "com.jo.laftelclone.feature.storage"
}

dependencies {
    implementation(projects.core.designsystem)
    testImplementation(projects.core.screenshotTesting)
}