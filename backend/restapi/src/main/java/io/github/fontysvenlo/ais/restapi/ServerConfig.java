package io.github.fontysvenlo.ais.restapi;

import java.util.Properties;

/**
 * Represents the configuration of the REST API server.
 * @param port The port to bind the server to
 */
public record ServerConfig(int port, int cors) {
    /**
     * Creates a ServerConfig object from a Properties object.
     * @param properties the properties object to create the ServerConfig from
     * @return the created ServerConfig object
     */
    public static ServerConfig fromProperties(Properties properties) {
        return new ServerConfig(
            Integer.parseInt(properties.getProperty("backend.port")),
            Integer.parseInt(properties.getProperty("frontend.port"))
        );
    }
}
