plugins {
    alias(libs.plugins.jo.android.library.compose)
    alias(libs.plugins.jo.hilt)
    alias(libs.plugins.jo.room)
}

android {
    namespace = "com.jo.laftelclone.core.database"
}