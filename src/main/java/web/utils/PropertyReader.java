package web.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    static Properties properties;

    public PropertyReader(String fileName) {
        loadAllProperties(fileName);
    }

    public void loadAllProperties(String fileName) {
        properties = new Properties();
        try {
            String propertyFilePath = System.getProperty("user.dir") + "/src/main/resources/properties/" + fileName;
            properties.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Could not read the properties file");
        }
    }

    public static String readItem(String propertyName) {
        return properties.getProperty(propertyName);
    }

}