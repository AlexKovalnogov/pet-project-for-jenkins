package org.example.configInitialization;

import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
    private static final String PROPERTY_FILE_NAME = "config.properties";

    public static Properties read(String propName) {
        Properties p = new Properties();
        try {
            p.load(ConfigReader.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p;
    }
}
