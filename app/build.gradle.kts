plugins {
    id("jo.plugin.application.compose")
    id("jo.plugin.hilt")
}

android {
    namespace = "com.jo.laftelclone"

    defaultConfig {
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level
    }
}

dependencies {
    implementation(project(":feature:home"))
}