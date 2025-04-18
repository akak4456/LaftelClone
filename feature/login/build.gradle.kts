plugins {
    alias(libs.plugins.jo.feature)
}

android {
    namespace = "com.jo.laftelclone.feature.login"
}

dependencies {
    implementation(projects.core.designsystem)
    testImplementation(projects.core.screenshotTesting)
}