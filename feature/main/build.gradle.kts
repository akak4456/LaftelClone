plugins {
    id("jo.plugin.feature")
    id("jo.plugin.hilt")
}

android {
    namespace = "com.jo.laftelclone.feature.main"
}

dependencies {
    implementation(project(":core:designsystem"))

    implementation(project(":feature:home"))
    implementation(project(":feature:tagsearch"))
    implementation(project(":feature:storage"))
    implementation(project(":feature:my"))

    testImplementation(project(":core:screenshot-testing"))
}