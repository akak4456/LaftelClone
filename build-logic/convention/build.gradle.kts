import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.jo.module.buildlogic"

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
        register("JavaLibraryPlugin") {
            id = "jo.plugin.java.library"
            implementationClass = "JavaLibraryConventionPlugin"
        }
        register("AndroidLibraryComposePlugin") {
            id = "jo.plugin.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("FeaturePlugin") {
            id = "jo.plugin.feature"
            implementationClass = "FeatureConventionPlugin"
        }

        //
    }
}