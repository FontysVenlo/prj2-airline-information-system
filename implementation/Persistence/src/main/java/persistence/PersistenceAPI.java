package persistence;

/**
 * Persistence API that gives access to all different storage providers
 * 
 * @author m.bonajo@fontys.nl
 */
public interface PersistenceAPI {
    
    /**
     * Get the customer storage provider
     * 
     * @return CustomerStorageService
     */
    CustomerStorageService getCustomerStorage();
    
}
