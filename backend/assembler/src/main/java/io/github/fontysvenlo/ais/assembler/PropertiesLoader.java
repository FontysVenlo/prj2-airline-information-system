package io.github.fontysvenlo.ais.assembler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is responsible for loading properties files containing configuration data.
 */
public class PropertiesLoader {
    /**
     * Private constructor to prevent instantiation.
     */
    private PropertiesLoader() {}

    /**
     * Loads a properties file from the classpath.
     * @param resourceFileName the name of the properties file. This file should be located in the resources folder.
     * @return the properties loaded from the file
     */
    public static Properties loadProperties(String resourceFileName) {
        Properties properties = new Properties();
        try (InputStream dbProperties = PropertiesLoader.class.getClassLoader().getResourceAsStream(resourceFileName);) {
            properties.load(dbProperties);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return properties;
    }
}
