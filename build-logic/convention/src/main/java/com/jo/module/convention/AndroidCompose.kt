package com.jo.module.convention

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.internal.utils.configureKotlinCompileForProject
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.provideDelegate
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    commonExtension.apply {
        compileSdk = 35
        buildFeatures.compose = true

        defaultConfig {
            minSdk = 24
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("compose.compiler").get().requiredVersion
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

    }

    configure<KotlinAndroidProjectExtension> {
        compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
    }

    dependencies {
        // Disabling to work with Alpha
        "api"(platform(libs.findLibrary("androidx-compose-bom").get()))
        "implementation"(libs.findBundle("compose").get())
        "debugImplementation"(libs.findBundle("compose.debug").get())
    }
}