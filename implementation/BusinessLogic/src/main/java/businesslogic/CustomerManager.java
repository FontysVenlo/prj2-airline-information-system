package businesslogic;

import businessentities.CustomerData;
import java.time.LocalDate;
import java.util.Optional;
import persistence.CustomerStorageService;

/**
 * Manager to handle all interaction with customer data
 * 
 * @author m.bonajo@fontys.nl
 */
public class CustomerManager {
    
    private final CustomerStorageService customerStorageService;

    /**
     * Create new customer manager to handle customer data
     * 
     * @param customerStorageService the storage service needed to interact
     * with the persistence layer
     */
    public CustomerManager(CustomerStorageService customerStorageService) {
        this.customerStorageService = customerStorageService;
    }

    public Optional<CustomerData> add(CustomerData customer) {
        return customerStorageService.add(customer);
    }
    
    public CustomerData createCustomer(String firstName, String lastName, LocalDate birthDate) {
        return new CustomerData(firstName, lastName, birthDate);
    }
    
}
