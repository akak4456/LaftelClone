import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.jo.laftelclone.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies{
    implementation(libs.androidx.room.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ksp.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("AndroidApplicationComposePlugin") {
            id = "jo.plugin.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("AndroidLibraryComposePlugin") {
            id = "jo.plugin.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("FeaturePlugin") {
            id = "jo.plugin.feature"
            implementationClass = "FeatureConventionPlugin"
        }
        register("HiltConventionPlugin") {
            id = "jo.plugin.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("AndroidRoomConventionPlugin") {
            id = "jo.plugin.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
    }
}