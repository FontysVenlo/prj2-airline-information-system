package io.github.fontysvenlo.ais.restapi;

import io.github.fontysvenlo.ais.persistence.PersistenceFactory;
import io.github.fontysvenlo.ais.businesslogic.BusinessLogicAPI;
import io.github.fontysvenlo.ais.businesslogic.BusinessLogicFactory;
import io.javalin.Javalin;

public class RESTServer {
    public static void main(String[] args) {
        BusinessLogicAPI businessLogic = BusinessLogicFactory.getImplementation( PersistenceFactory.getImplementation() );

        Javalin.create(/*config*/)
            .get("customers", context -> {
                context.json(businessLogic.getCustomerManager().list());
            })
            .post("customers", context -> {
                CustomerController.add(businessLogic, context);
            })
            .start(7070);
    }
}