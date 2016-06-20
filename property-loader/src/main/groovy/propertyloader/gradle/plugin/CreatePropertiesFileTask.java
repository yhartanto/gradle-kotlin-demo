package propertyloader.gradle.plugin;

import org.gradle.api.DefaultTask;
import org.gradle.api.GradleScriptException;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class CreatePropertiesFileTask extends DefaultTask {

    @Input
    public List<String> keys;

    @OutputFile
    public File keyFile;

    @TaskAction
    public void createFile() {
        try {
            Properties properties = new Properties();
            if (keys != null) {
                for (String key : keys) {
                    properties.put(key, key);
                }
            }

            if (keyFile != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(keyFile);
                properties.store(fileOutputStream, "");
            }
        } catch (FileNotFoundException fe) {
            throw new GradleScriptException("Error", fe);
        } catch (IOException ie) {
            throw new GradleScriptException("Error", ie);
        }
    }
}
