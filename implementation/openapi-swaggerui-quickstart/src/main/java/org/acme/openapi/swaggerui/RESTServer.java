package org.acme.openapi.swaggerui;

import businesslogic.BusinessLogicAPI;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@QuarkusMain
//@ApplicationScoped
public class RESTServer {

    private BusinessLogicAPI api;

//    public RESTServer(BusinessLogicAPI api) {
//        this.api = api;
//        System.out.println("Running main method");
//        Quarkus.run(new String[]{});
//    }

    public static void main(String... args) {
        System.out.println("Running main method");
        Quarkus.run(args);
    }

    public void start(BusinessLogicAPI api) {
        this.api = api;
        System.out.println("REST Server started asgdjshdg");
//        System.out.println("USER DIRECTORY: " + System.getProperty("user.dir"));
//        System.setProperty("user.dir", "/Users/hvd/data/fontys/moduleRepos/prj2-airline-information-system/implementation/openapi-swaggerui-quickstart"); 
//        System.out.println("USER DIRECTORY: " + System.getProperty("user.dir"));
        //Quarkus.run(new String[]{});
    }
    
            

}
