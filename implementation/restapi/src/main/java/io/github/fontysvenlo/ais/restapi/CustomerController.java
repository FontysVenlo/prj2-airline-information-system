package io.github.fontysvenlo.ais.restapi;

import io.github.fontysvenlo.ais.businesslogic.BusinessLogicAPI;
import io.github.fontysvenlo.ais.datarecords.CustomerData;
import io.javalin.http.Context;

/**
 * This class is responsible for handling the requests for the customer resource.
 */
class CustomerController {
    private BusinessLogicAPI businessLogic;

    /**
     * Initializes the controller with the business logic.
     */
    CustomerController(BusinessLogicAPI businessLogic) {
        this.businessLogic = businessLogic;
    }

    /**
     * Adds a customer to the storage.
     * - If the customer data is null, the status is set to 400 (Bad Request).
     * - Otherwise, the status is set to 201 (Created) and the added customer is returned as JSON.
     */
    void add(Context context) {
        CustomerData customerData = context.bodyAsClass(CustomerData.class);
        System.out.println(customerData);
        if (customerData == null) {
            context.status(400);
            return;
        }
        context.status(201);
        context.json(businessLogic.getCustomerManager().add(customerData));
    }

    /**
     * Retrieves all customers from the storage.
     * - The status is set to 200 (OK) and the list of customers is returned as JSON.
     */
    void list(Context context) {
        context.status(200);
        context.json(businessLogic.getCustomerManager().list());
    }
}