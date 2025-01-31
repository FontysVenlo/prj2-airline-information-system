package io.github.fontysvenlo.ais.restapinomdule;

// import businesslogic.BusinessLogicAPI;
// import datarecords.CustomerData;
// import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * Endpoint for customers
 */
@Path("/customers")
public class CustomerResource {
    // @Inject
    // BusinessLogicAPI businessLogic;

    public CustomerResource() {
        System.out.println("Resource Constructed");
    }

    @GET
    public String get() {
        System.out.println("Resource get method called");
        return "HELLO";
    }

    // @POST
    // public CustomerData add() {
    //     System.out.println("Resource add method called");
    //     // TODO: change to POST with actual customer data
    //     return businessLogic.getCustomerManager().add(new CustomerData(777, "Lennart", "Tange", LocalDate.of(1988, 2, 17)));
    // }
}