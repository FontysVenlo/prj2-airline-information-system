package restapi;

import persistence.PersistenceFactory;
import businesslogic.BusinessLogicAPI;
import businesslogic.BusinessLogicFactory;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@QuarkusMain
public class RESTServer {
    public static void main(String... args) {
        System.out.println("Running main method");
        Quarkus.run(args);
    }

    @Produces
    public BusinessLogicAPI businessLogic() {
        System.out.println("API instantiated");
        return BusinessLogicFactory.getImplementation( PersistenceFactory.getImplementation() );
    }
}
