package me.samuki.buildlogic.utils

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.configureCompose(
    commonExtension: CommonExtension<*, *, *, *>
) {
    commonExtension.apply {
        buildFeatures.compose = true
        composeOptions.kotlinCompilerExtensionVersion = "1.4.0"
    }

    dependencies {
        implementation("androidx.compose.ui:ui:1.4.0-alpha05")
        implementation("androidx.compose.ui:ui-tooling-preview:1.4.0-alpha05")
        implementation("androidx.compose.material:material:1.4.0-alpha05")
        implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha05")
        debugImplementation("androidx.compose.ui:ui-tooling:1.4.0-alpha05")
        debugImplementation("androidx.compose.ui:ui-test-manifest:1.4.0-alpha05")

        implementation("com.github.SamukiPL:composable-event:1.0.1")
    }
}
