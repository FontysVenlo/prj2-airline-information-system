package persistence;

/**
 *
 * @author m.bonajo@fontys.nl
 */
class PersistenceAPIImpl implements PersistenceAPIProvider {
    
    // Make sure to have or establish a connection to the database

    @Override
    public CustomerStorageService getCustomerStorage() {
        return new CustomerStorageServiceImpl();
    }
    
}
