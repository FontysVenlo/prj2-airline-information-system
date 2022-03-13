package businesslogic;

import datarecords.CustomerData;
import persistence.CustomerStorageService;

/**
 * Manages customers in the business logic.
 * Linking pin between GUI and persistence. Connected to customerStorageService 
 * in order to retrieve customers and to persist changes.
 * 
 * @author Informatics Fontys Venlo
 */
public class CustomerManager {
    
    private final CustomerStorageService customerStorageService;

    public CustomerManager( CustomerStorageService customerStorageService ) {
        this.customerStorageService = customerStorageService;
    }
    
    public CustomerData add( CustomerData customerData ){
        return customerStorageService.add(customerData);
    }
    
}
