package io.github.fontysvenlo.ais.persistence.api;

/**
 * API for the persistence layer. Provides access to repositories.
 */
public interface Persistence {

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

    // This interface can be extended with other repositories that need to be made
    // available to the business logic, e.g. to manage flights:
    //
    //FlightRepository getFlightRepository();
}
