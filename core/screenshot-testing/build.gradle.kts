plugins {
    id("jo.plugin.android.library.compose")
}

android {
    namespace = "com.jo.laftelclone.core.screenshot_testing"
}

dependencies {
    implementation(libs.roborazzi)
    implementation(libs.roborazzi.compose)
    implementation(libs.roborazzi.accessibility.check)
    implementation(libs.robolectric)

    implementation(project(":core:designsystem"))
}