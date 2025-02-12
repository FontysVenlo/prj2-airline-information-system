package io.github.fontysvenlo.ais.restapi;

import java.util.Properties;

/**
 * Represents the configuration of the REST API server.
 */
public record ServerConfig(int port) {
    /**
     * Creates a ServerConfig object from a Properties object.
     * @param properties the properties object to create the ServerConfig from
     * @return the created ServerConfig object
     */
    public static ServerConfig fromProperties(Properties properties) {
        return new ServerConfig(Integer.parseInt(properties.getProperty("server.port")));
    }
}
