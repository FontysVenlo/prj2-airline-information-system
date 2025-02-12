package io.github.fontysvenlo.ais.persistence;

/**
 * API for the persistence layer. Provides access to repositories.
 */
public interface PersistenceAPI {

    /**
     * Get CustomerRepository. Provides a storage object that knows how to
     * store and retrieve customers. Implemented by a default method, to enable
     * creation of customized PersistenceFacade implementations with limited
     * services, for test purposes.
     *
     * @return CustomerRepository object that knows how to store and
     * retrieve customers.
     */
    default CustomerRepository getCustomerRepository() {
        return null;
    }

    // This interface can be extended with all services that need to be made
    // available to the business logic, e.g. to store Products:
    //
    // ProductStorageService getProductStorageService( );
}
