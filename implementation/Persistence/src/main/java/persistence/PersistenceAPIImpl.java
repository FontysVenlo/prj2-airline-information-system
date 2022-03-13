package persistence;

/**
 * Actual creator of storage services.
 * @author Richard van den Ham / Martijn Bonajo
 */
public class PersistenceAPIImpl implements PersistenceAPI{

    @Override
    public CustomerStorageService getCustomerStorageService() {
        return new CustomerStorageServiceImpl();
    }
    
    
    
}
