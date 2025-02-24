package io.github.fontysvenlo.ais.restapi;

import static io.javalin.apibuilder.ApiBuilder.crud;

import io.javalin.Javalin;
import io.github.fontysvenlo.ais.businesslogic.api.BusinessLogic;


/**
 * This class is responsible for starting the REST server and defining the routes.
 */
public class APIServer {
    private final BusinessLogic businessLogic;

    /**
     * Initializes the REST API server
     * @param businessLogic the business logic implementation to communicate with
     */
    public APIServer(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    /**
     * Starts the REST API server
     * @param configuration the configuration of the server
     */
    public void start(ServerConfig configuration) {
        var app = Javalin.create(config -> {
            config.router.contextPath = "/api/v1";
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(it -> {
                    it.allowHost("http://localhost:" + configuration.allowhostport(), "127.0.0.1:" + configuration.allowhostport());
                });
            });
            config.router.apiBuilder(() -> {
                crud("customers/{customer-id}", new CustomerResource(businessLogic));
            });
        });

        app.start(configuration.port());
    }
}