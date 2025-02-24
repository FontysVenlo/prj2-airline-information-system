package io.github.fontysvenlo.ais.assembler;

import java.util.Properties;

import io.github.fontysvenlo.ais.persistence.DBConfig;
import io.github.fontysvenlo.ais.persistence.PersistenceFactory;

import io.github.fontysvenlo.ais.businesslogic.BusinessLogicFactory;

import io.github.fontysvenlo.ais.restapi.APIServer;
import io.github.fontysvenlo.ais.restapi.ServerConfig;
import io.github.fontysvenlo.ais.businesslogic.api.BusinessLogic;
import io.github.fontysvenlo.ais.persistence.api.Persistence;

/**
 * The Assembler class starts different layers of the application and connects them.
 */
public class Assembler {
    /**
     * Private constructor to prevent instantiation.
     */
    private Assembler() {}

    /**
     * Starts the application with the given configurations.
     * @param dbConfig the database configuration
     * @param serverConfig the server configuration
     */
    public static void start(DBConfig dbConfig, ServerConfig serverConfig) {
        
        Persistence persistence = PersistenceFactory.getInstance(dbConfig);
        
        BusinessLogic businessLogic = BusinessLogicFactory.getInstance(persistence);

        APIServer restServer = new APIServer(businessLogic);
        
        restServer.start(serverConfig);
    }

    /**
     * The main method starts the application from the properties files.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Properties dbProperties = PropertiesLoader.loadProperties("db.properties");
        DBConfig databaseConfig = DBConfig.fromProperties(dbProperties, "aisdb");

        Properties serverProperties = PropertiesLoader.loadProperties("application.properties");
        ServerConfig serverConfig = ServerConfig.fromProperties(serverProperties);

        start(databaseConfig, serverConfig);
    }
}
