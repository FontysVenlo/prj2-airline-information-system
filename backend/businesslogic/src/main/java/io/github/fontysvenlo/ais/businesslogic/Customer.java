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
        if (customerData.firstName().isBlank() || customerData.firstName().length() < 2) {
            throw new IllegalArgumentException("Customer first name is not allowed to be empty or less than 2 characters");
        }
        this.customerData = customerData;
    }

    // Write Customer Business Logic (methods) here
    // Changes to CustomerData would mean creation of a new CustomerData
    // object and replace the existing object.


}
