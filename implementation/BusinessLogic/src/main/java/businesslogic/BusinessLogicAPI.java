package businesslogic;

/**
 * Interface defining all the manager that are supported by the business logic
 * @author fontys
 */
public interface BusinessLogicAPI {
    
    /**
     * Get the customer manager to manage customer
     * @return CustomerManager
     */
    CustomerManager getCustomerManager();
            
}
