package propertyloader.gradle.plugin.kotlin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.util.*

open class CreatePropertiesFileTask() : DefaultTask() {
    @Input var keys: List<String> = ArrayList()

    @OutputFile var keyFile: File? = null

    fun getProp(key: String): String {
        return key
    }

    @TaskAction
    fun createFile() {
        val properties = Properties()
        keys.forEach { key -> properties.put(key, getProp(key)) }
        properties.store(keyFile!!.outputStream(), "")
    }
}
