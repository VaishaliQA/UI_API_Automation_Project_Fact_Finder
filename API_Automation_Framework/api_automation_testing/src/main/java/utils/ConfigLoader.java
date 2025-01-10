package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties;

    public static void loadConfig() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
