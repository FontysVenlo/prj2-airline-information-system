package io.github.fontysvenlo.ais.businesslogic.api;

import io.github.fontysvenlo.ais.datarecords.CustomerData;
import java.util.List;

/**
 * Interface for objects that are able to manage Customers.
 */
public interface CustomerManager {

    /**
     * Add a customer.
     *
     * @param customerData the customer to add
     * @return the added customer data
     */
    public CustomerData add(CustomerData customerData);

    /**
     * Retrieve all customers.
     *
     * @return a list of all customers
     */
    public List<CustomerData> list();

}
