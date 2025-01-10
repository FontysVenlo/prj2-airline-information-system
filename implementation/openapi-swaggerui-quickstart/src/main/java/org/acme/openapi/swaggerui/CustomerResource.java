package org.acme.openapi.swaggerui;

import businesslogic.BusinessLogicAPI;
import datarecords.CustomerData;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/customers")
public class CustomerResource {
    
    
    private BusinessLogicAPI api;
    private Set<CustomerData> customers = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public CustomerResource(int api) {
        //this.api = api;     
        //CustomerData customerData = api.getCustomerManager().add(new CustomerData(777, "Lennart", "Tange", LocalDate.of(1988, 2, 17)));
        //customers.add(customerData);
        System.out.println("Resource Constructed");
    }

    @GET
    public Set<CustomerData> list() {
        return customers;
    }

}