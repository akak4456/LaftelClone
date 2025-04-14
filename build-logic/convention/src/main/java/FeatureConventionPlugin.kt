@file:Suppress("unused")

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/**
 * feature>...
 * module 에 공통적으로 들어갈만한 gradle 설정은 여기에 하자
 */
internal class FeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("jo.plugin.android.library.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("io.github.takahirom.roborazzi")
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            val extension = extensions.getByType<LibraryExtension>()
            (extension as CommonExtension<*, *, *, *>).apply {
                testOptions {
                    unitTests {
                        isIncludeAndroidResources = true
                    }
                }
            }
            dependencies {
                "testImplementation"(libs.findLibrary("roborazzi").get())
                "testImplementation"(libs.findLibrary("roborazzi-compose").get())
                "testImplementation"(libs.findLibrary("roborazzi-accessibility-check").get())
                "testImplementation"(libs.findLibrary("robolectric").get())
            }
        }
    }
}