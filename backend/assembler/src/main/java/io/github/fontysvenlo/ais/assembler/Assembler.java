package io.github.fontysvenlo.ais.assembler;

import java.util.Properties;

import io.github.fontysvenlo.ais.businesslogic.BusinessLogicAPI;
import io.github.fontysvenlo.ais.businesslogic.BusinessLogicFactory;

import io.github.fontysvenlo.ais.persistence.DBConfig;
import io.github.fontysvenlo.ais.persistence.PersistenceFactory;
import io.github.fontysvenlo.ais.restapi.APIServer;
import io.github.fontysvenlo.ais.restapi.ServerConfig;

/**
 * The Assembler class starts different layers of the application and connects them.
 */
public class Assembler {
    /**
     * Starts the application with the given configurations.
     * @param dbConfig the database configuration
     * @param serverConfig the server configuration
     */
    public static void start(DBConfig dbConfig, ServerConfig serverConfig) {
        BusinessLogicAPI businessLogic = BusinessLogicFactory.getImplementation(PersistenceFactory.getImplementation(dbConfig));

        APIServer restServer = new APIServer(businessLogic);
        restServer.start(serverConfig);
    }

    /**
     * The main method starts the application from the properties files.
     */
    public static void main(String[] args) {
        Properties dbProperties = PropertiesLoader.loadProperties("db.properties");
        DBConfig databaseConfig = DBConfig.fromProperties(dbProperties, "aisdb");

        Properties serverProperties = PropertiesLoader.loadProperties("application.properties");
        ServerConfig serverConfig = ServerConfig.fromProperties(serverProperties);

        start(databaseConfig, serverConfig);
    }
}
