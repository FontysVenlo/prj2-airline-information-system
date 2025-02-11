package io.github.fontysvenlo.ais.restapi;

import io.github.fontysvenlo.ais.persistence.DBConfig;
import io.github.fontysvenlo.ais.persistence.DBProvider;
import io.github.fontysvenlo.ais.persistence.PersistenceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.github.fontysvenlo.ais.businesslogic.BusinessLogicAPI;
import io.github.fontysvenlo.ais.businesslogic.BusinessLogicFactory;
import io.javalin.Javalin;

/**
 * This class is responsible for starting the REST server and defining the routes.
 */
public class RESTServer {
    private final static int PORT = 5173;

    /**
     * Main method to start the REST server
     */
    public static void main(String[] args) {
        DBConfig databaseConfig = DBConfig.fromProperties(loadProperties("db.properties"), "aisdb");
        BusinessLogicAPI businessLogic = BusinessLogicFactory.getImplementation(PersistenceFactory.getImplementation(databaseConfig));

        CustomerController customerController = new CustomerController(businessLogic);

        Javalin.create(config -> {
                config.router.contextPath = "/api/v1";
                config.bundledPlugins.enableCors(cors -> {
                    cors.addRule(it -> {
                        it.allowHost("http://localhost:" + PORT, "127.0.0.1:5173" + PORT);
                    });
                });
            })
            .get("customers", context -> {
                customerController.list(context);
            })
            .post("customers", context -> {
                customerController.add(context);
            })
            .start(PORT);
    }

    private static Properties loadProperties(String resourceFileName) {
        Properties properties = new Properties();
        try (InputStream dbProperties = RESTServer.class.getClassLoader().getResourceAsStream(resourceFileName);) {
            properties.load(dbProperties);
        } catch (IOException ex) {
            Logger.getLogger(DBProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return properties;
    }
}