package persistence;

/**
 * Actual creator of storage services.
 * @author Informatics Fontys Venlo
 */
class PersistenceAPIImpl implements PersistenceAPI{

    @Override
    public CustomerStorageService getCustomerStorageService() {
        return new CustomerStorageServiceImpl();
    }
    
    
    
}
