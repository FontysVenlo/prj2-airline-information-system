package io.github.fontysvenlo.ais.assembler;

import java.util.Properties;

import io.github.fontysvenlo.ais.businesslogic.BusinessLogicAPI;
import io.github.fontysvenlo.ais.businesslogic.BusinessLogicFactory;

import io.github.fontysvenlo.ais.persistence.DBConfig;
import io.github.fontysvenlo.ais.persistence.PersistenceFactory;
import io.github.fontysvenlo.ais.restapi.APIServer;
import io.github.fontysvenlo.ais.restapi.ServerConfig;


public class Assembler {
    public static void main(String[] args) {
        Properties dbProperties = PropertiesLoader.loadProperties("db.properties");
        DBConfig databaseConfig = DBConfig.fromProperties(dbProperties, "aisdb");

        Properties serverProperties = PropertiesLoader.loadProperties("application.properties");
        ServerConfig serverConfig = ServerConfig.fromProperties(serverProperties);

        BusinessLogicAPI businessLogic = BusinessLogicFactory.getImplementation(PersistenceFactory.getImplementation(databaseConfig));

        APIServer restServer = new APIServer(businessLogic);
        restServer.start(serverConfig);
    }
}
