package com.jo.laftelclone.convention

import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
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

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().requiredVersion
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

    }

    (commonExtension as? LibraryExtension)?.apply {
        defaultConfig {
            consumerProguardFiles("consumer-rules.pro")
        }

        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }

    configure<KotlinAndroidProjectExtension> {
        compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
    }

    dependencies {
        // Disabling to work with Alpha
        "implementation"(libs.findLibrary("androidx-core-ktx").get())
        "implementation"(libs.findLibrary("androidx-lifecycle-runtime-ktx").get())
        "api"(platform(libs.findLibrary("androidx-compose-bom").get()))
        "implementation"(libs.findBundle("compose").get())
        "implementation"(libs.findLibrary("androidx-appcompat").get())
        "implementation"(libs.findLibrary("material").get())

        "debugImplementation"(libs.findBundle("compose.debug").get())

        "testImplementation"(libs.findLibrary("junit").get())
        "testImplementation"(libs.findLibrary("mockito").get())
        "testImplementation"(libs.findLibrary("mockito-kotlin").get())
        "testImplementation"(libs.findLibrary("coroutines-test").get())
        "androidTestImplementation"(libs.findLibrary("androidx-junit-compose").get())
        "androidTestImplementation"(libs.findLibrary("androidx-junit").get())
        "androidTestImplementation"(libs.findLibrary("androidx-espresso-core").get())
    }
}