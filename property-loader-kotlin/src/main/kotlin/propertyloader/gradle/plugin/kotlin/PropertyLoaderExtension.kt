package propertyloader.gradle.plugin.kotlin

import org.gradle.api.Project
import java.io.File
import java.util.*

data class PropertyLoaderExtension(val project: Project,
                                   var keys: List<String> = ArrayList(),
                                   var customFile: File? = null) {
    fun customPropertiesFile(filename: String) {
        customFile = File(filename)
    }

    fun getProp(key: String): String {
        val value: String = System.getProperty(key) ?:
                if (project.hasProperty(key)) {
                    project.property(key) as String
                } else {
                    ""
                }
        return value
    }

}

