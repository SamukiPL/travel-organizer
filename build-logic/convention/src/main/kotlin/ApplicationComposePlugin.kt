import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import me.samuki.buildlogic.utils.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class ApplicationComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<BaseAppModuleExtension> {
                configureCompose(this)
            }
        }
    }
}
