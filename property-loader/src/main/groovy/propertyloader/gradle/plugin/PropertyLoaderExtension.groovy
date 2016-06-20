package propertyloader.gradle.plugin

import org.gradle.api.Project

class PropertyLoaderExtension {

    List<String> keys = [];
    File customPropertiesFile;
    Project project;

    PropertyLoaderExtension(Project project) {
        this.project = project;
    }

    void customPropertiesFile(String filename) {
        customPropertiesFile = new File(filename);
    }

    def getProp(String key) {
        if (System.properties.get(key) != null) {
            return System.properties.get(key)
        } else if (project.hasProperty(key)) {
            return project.property(key)
        } else {
            customPropertiesFile.withInputStream {
                Properties properties = new Properties()
                properties.load(it)
                if (properties.containsKey(it)) {
                    return it
                }
            }
        }
    }
}
