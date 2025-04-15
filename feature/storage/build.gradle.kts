plugins {
    id("jo.plugin.feature")
    id("jo.plugin.hilt")
}

android {
    namespace = "com.jo.laftelclone.feature.storage"
}

dependencies {
    implementation(project(":core:designsystem"))
    testImplementation(project(":core:screenshot-testing"))
}