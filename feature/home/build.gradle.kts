plugins {
    id("jo.plugin.feature")
}

android {
    namespace = "com.jo.laftelclone.feature.home"
}

dependencies {
    implementation(project(":core:designsystem"))
    testImplementation(project(":core:screenshot-testing"))
}