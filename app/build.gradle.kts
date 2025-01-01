plugins {
    id("jo.plugin.application.compose")
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
    implementation(project(":feature:tagsearch"))
    implementation(project(":feature:box"))
    implementation(project(":feature:my"))
}