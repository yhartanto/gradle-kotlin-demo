package propertyloader.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class PropertyLoaderPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.configure(project) {
            def propertyLoader = extensions.create("propertyLoader", PropertyLoaderExtension, project)
            afterEvaluate {
                if (!propertyLoader.keys.isEmpty()) {
                    project.tasks.create("createCustomPropertiesFile", CreatePropertiesFileTask) {
                        it.keyFile = propertyLoader.customPropertiesFile
                        it.keys = propertyLoader.keys
                    }
                }
            }
        }

    }
}

