package org.example.configInitialization;

import java.util.Properties;

public  class AppConfig {
    private static final String PROPERTY_FILE_NAME = "config.properties";
    public static final String MAIN_URL;
    public static final String BROWSER;

    static {
      Properties configFileProps= ConfigReader.read(PROPERTY_FILE_NAME);

        MAIN_URL = configFileProps.getProperty("MAIN_URL");
        BROWSER = configFileProps.getProperty("BROWSER");
    }

}
