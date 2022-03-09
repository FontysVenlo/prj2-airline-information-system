package persistence;

import businessentities.CustomerData;
import java.util.List;
import java.util.Optional;

/**
 * Storage service for customer data
 * 
 * @author m.bonajo@fontys.nl
 */
public interface CustomerStorageService {
    
    /**
     * Try to store a customer in the database
     * @param customer the data of the customer
     * @return customer data if the operation was successful
     *  or empty optional if not successful
     */
    Optional<CustomerData> add(CustomerData customer);
    
    /**
     * Retrieve all customers from the database
     * @return List of all customers in the database
     *  or empty list when no customers present
     */
    List<CustomerData> getAll();
    
}
