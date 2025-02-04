package io.github.fontysvenlo.ais.restapi;

import io.github.fontysvenlo.ais.persistence.PersistenceFactory;
import io.github.fontysvenlo.ais.businesslogic.BusinessLogicAPI;
import io.github.fontysvenlo.ais.businesslogic.BusinessLogicFactory;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;
import jakarta.enterprise.inject.Produces;

/**
 * Main application class to start the REST API server.
 */
@QuarkusMain
public class RESTServer {
    public static void main(String... args) {
        Quarkus.run(args);
    }

    /**
     * Provide the BusinessLogicAPI implementation, so that it can be injected into the resources.
     */
    @Produces
    public BusinessLogicAPI businessLogic() {
        return BusinessLogicFactory.getImplementation( PersistenceFactory.getImplementation() );
    }
}
