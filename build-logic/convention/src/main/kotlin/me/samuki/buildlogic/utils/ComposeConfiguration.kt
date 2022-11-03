package me.samuki.buildlogic.utils

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.configureCompose(
    commonExtension: CommonExtension<*, *, *, *>
) {
    commonExtension.apply {
        buildFeatures.compose = true
        composeOptions.kotlinCompilerExtensionVersion = "1.2.0"
    }

    dependencies {
        implementation("androidx.compose.ui:ui:1.3.0")
        implementation("androidx.compose.ui:ui-tooling-preview:1.3.0")
        implementation("androidx.compose.material:material:1.3.0")
        implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
        debugImplementation("androidx.compose.ui:ui-tooling:1.3.0")
        debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.0")

        implementation("com.github.SamukiPL:composable-event:1.0.0")
    }
}
