plugins {
    id("jo.plugin.feature")
}

android {
    namespace = "com.jo.laftelclone.feature.splash"
}

dependencies {
    implementation(project(":core:designsystem"))
}