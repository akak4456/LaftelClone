plugins {
    alias(libs.plugins.jo.feature)
    alias(libs.plugins.jo.hilt)
}

android {
    namespace = "com.jo.laftelclone.feature.main"
}

dependencies {
    implementation(projects.core.designsystem)

    implementation(projects.feature.home)
    implementation(projects.feature.tagsearch)
    implementation(projects.feature.storage)
    implementation(projects.feature.my)

    testImplementation(projects.core.screenshotTesting)
}