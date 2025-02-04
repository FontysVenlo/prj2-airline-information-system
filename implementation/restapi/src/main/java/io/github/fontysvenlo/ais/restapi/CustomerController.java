package io.github.fontysvenlo.ais.restapi;

import io.github.fontysvenlo.ais.businesslogic.BusinessLogicAPI;
import io.github.fontysvenlo.ais.datarecords.CustomerData;
import io.javalin.http.Context;

public class CustomerController {
    public static void add(BusinessLogicAPI businessLogic, Context context) {
        CustomerData customerData = context.bodyAsClass(CustomerData.class);
        System.out.println(customerData);
        if (customerData == null) {
            context.status(400);
            return;
        }
        context.status(201);
        context.json(businessLogic.getCustomerManager().add(customerData));
    }

    public static void list(BusinessLogicAPI businessLogic, Context context) {
        context.status(200);
        context.json(businessLogic.getCustomerManager().list());
    }
}