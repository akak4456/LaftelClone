@file:Suppress("unused")

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
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {

                "implementation"(libs.findLibrary("androidx.appcompat").get())
                "implementation"(libs.findLibrary("androidx.core.ktx").get())

                "implementation"(libs.findLibrary("androidx.lifecycle.runtime.ktx").get())
            }
        }
    }
}