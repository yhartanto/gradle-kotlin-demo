package propertyloader.gradle.plugin.kotlin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionContainer

class PropertyLoaderPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configure {
            extensions {
                add("propertyLoaderKotlin", PropertyLoaderExtension(project))
            }
            afterEvaluate { project ->
                if (!propertyLoader().keys.isEmpty()) {
                    tasks.create("createPropertiesFileKotlin", CreatePropertiesFileTask::class.java) { task ->
                        task.keys = propertyLoader().keys
                        task.keyFile = propertyLoader().customFile!!
                    }
                }
            }
        }
    }
}

fun Project.configure(exec: Project.() -> Unit) = exec()
fun Project.extensions(exec: ExtensionContainer.() -> Unit) = extensions.exec()
fun Project.propertyLoader() = extensions.getByName("propertyLoaderKotlin") as PropertyLoaderExtension
