package io.github.fontysvenlo.ais.persistence;

import java.util.Properties;

/**
 * Configuration for instantiating the database connection, which could be specific to the environment
 * the application runs on.
 * @param namespace the namespace of the configuration, so that we can have multiple configurations at the same time
 * @param host the host of the database
 * @param port the port of the database
 * @param name the name of the database
 * @param schema the schema of the database
 * @param username the username to connect to the database
 * @param password the password to connect to the database
 */
public record DBConfig(String namespace, String host, int port, String name, String schema, String username, String password) {
    /**
     * Create a DBConfig from a Properties object.
     * @param properties the properties to create the DBConfig from
     * @param namespace the namespace of the configuration
     * @return the created DBConfig
     */
    public static DBConfig fromProperties(Properties properties, String namespace) {
        return new DBConfig(
                namespace,
                properties.getProperty(namespace + ".dbhost"),
                Integer.parseInt(properties.getProperty(namespace + ".port")),
                properties.getProperty(namespace + ".dbname"),
                properties.getProperty(namespace + ".schema"),
                properties.getProperty(namespace + ".username"),
                properties.getProperty(namespace + ".password")
        );
    }
}
