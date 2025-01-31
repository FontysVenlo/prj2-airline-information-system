package io.github.fontysvenlo.ais.restapi;

// import persistence.PersistenceFactory;
// import businesslogic.BusinessLogicAPI;
// import businesslogic.BusinessLogicFactory;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;

@QuarkusMain
public class RESTServer {
    public static void main(String... args) {
        System.out.println("Running main method");
        Quarkus.run(args);
    }

    // @Produces
    // public BusinessLogicAPI businessLogic() {
    //     System.out.println("API instantiated");
    //     return BusinessLogicFactory.getImplementation( PersistenceFactory.getImplementation() );
    // }
}
