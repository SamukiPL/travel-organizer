package me.samuki.buildlogic.utils

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun Project.configureCompose(
    commonExtension: CommonExtension<*, *, *, *>
) {
    commonExtension.apply {
        buildFeatures.compose = true
        composeOptions.kotlinCompilerExtensionVersion = "1.2.0"
    }

    dependencies {
        implementation("androidx.compose.ui:ui:1.2.1")
        implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
        implementation("androidx.compose.material:material:1.2.1")
        debugImplementation("androidx.compose.ui:ui-tooling:1.2.1")
        debugImplementation("androidx.compose.ui:ui-test-manifest:1.2.1")
    }
}
