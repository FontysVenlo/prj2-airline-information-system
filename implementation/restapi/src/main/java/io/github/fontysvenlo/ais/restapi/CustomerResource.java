package io.github.fontysvenlo.ais.restapi;

import org.jboss.resteasy.reactive.ResponseStatus;

import io.github.fontysvenlo.ais.businesslogic.BusinessLogicAPI;
import io.github.fontysvenlo.ais.datarecords.CustomerData;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


/**
 * Endpoint for Customers
 */
@Path("/customers")
public class CustomerResource {
    @Inject
    BusinessLogicAPI businessLogic;

    @GET
    public String get() {
        return "HELLO";
    }

    @POST
    @ResponseStatus(201)
    public CustomerData add(CustomerData customerData) {
        if (customerData == null) {
            throw new BadRequestException("No customer provided");
        }
        return businessLogic.getCustomerManager().add(customerData);
    }
}
