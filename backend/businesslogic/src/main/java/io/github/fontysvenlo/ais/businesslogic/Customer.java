package io.github.fontysvenlo.ais.businesslogic;

import io.github.fontysvenlo.ais.datarecords.CustomerData;

/**
 * Wrapper class that contains CustomerData and Customer Business Logic.
 */
public class Customer {

    private CustomerData customerData;

    /**
     * Constructor
     * @param customerData the customer data
     */
    public Customer(CustomerData customerData) {
        this.customerData = customerData;
    }

    // Write Customer Business Logic (methods) here
    // Changes to CustomerData would mean creation of a new CustomerData
    // object and replace the existing object.


}
