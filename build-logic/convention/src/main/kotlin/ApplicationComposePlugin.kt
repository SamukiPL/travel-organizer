import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import me.samuki.buildlogic.utils.configureCompose
import me.samuki.buildlogic.utils.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class ApplicationComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<BaseAppModuleExtension> {
                configureCompose(this)
            }

            dependencies {
                implementation("androidx.activity:activity-compose:1.6.1")
            }
        }
    }
}
