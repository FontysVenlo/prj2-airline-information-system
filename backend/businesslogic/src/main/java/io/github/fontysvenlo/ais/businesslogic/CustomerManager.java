package io.github.fontysvenlo.ais.businesslogic;

import java.util.List;

import io.github.fontysvenlo.ais.datarecords.CustomerData;
import io.github.fontysvenlo.ais.persistence.CustomerRepository;


/**
 * Manages customers in the business logic.
 * Linking pin between GUI and persistence. Connected to CustomerRepository
 * in order to retrieve customers and to persist changes.
 */
public class CustomerManager {

    private final CustomerRepository CustomerRepository;

    /**
     * Constructor
     * @param CustomerRepository the customer storage service
     */
    public CustomerManager( CustomerRepository CustomerRepository ) {
        this.CustomerRepository = CustomerRepository;
    }

    /**
     * Adds a customer to the storage.
     * @param customerData the customer to add
     * @return the added customer data
     */
    public CustomerData add( CustomerData customerData ){
        return CustomerRepository.add(customerData);
    }

    /**
     * Retrieves all customers from the storage.
     * @return a list of all customers
     */
    public List<CustomerData> list(){
        return CustomerRepository.getAll();
    }

}
