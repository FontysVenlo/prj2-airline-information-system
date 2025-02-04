package io.github.fontysvenlo.ais.businesslogic;

import io.github.fontysvenlo.ais.persistence.PersistenceAPI;
import io.github.fontysvenlo.ais.persistence.CustomerStorageService;

/**
 * Actual business logic implementation.
 */
class BusinessLogicAPIImpl implements BusinessLogicAPI {

    final PersistenceAPI persistenceAPI;

    /**
     * Constructor.
     * @param persistenceAPI the PersistenceAPI
     */
    BusinessLogicAPIImpl(PersistenceAPI persistenceAPI) {
        this.persistenceAPI = persistenceAPI;
    }

    /**
     * Get the implementation of the CustomerManager.
     * @return the implementation of the CustomerManager
     */
    @Override
    public CustomerManager getCustomerManager() {
        return new CustomerManager(persistenceAPI.getCustomerStorageService());
    }
}
