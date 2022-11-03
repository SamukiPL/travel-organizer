import me.samuki.buildlogic.utils.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

class HiltComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.dagger.hilt.android")
            }

            extensions.configure<KaptExtension> {
                correctErrorTypes = true
            }

            dependencies {
                implementation("androidx.navigation:navigation-compose:2.5.3")
                implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
            }
        }
    }
}
