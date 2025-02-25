package io.github.fontysvenlo.ais.businesslogic;

import io.github.fontysvenlo.ais.businesslogic.api.CustomerManager;
import io.github.fontysvenlo.ais.businesslogic.api.BusinessLogic;
import io.github.fontysvenlo.ais.persistence.api.Persistence;

/**
 * Actual business logic implementation.
 */
class BusinessLogicImpl implements BusinessLogic {

    final Persistence persistenceAPI;

    /**
     * Constructor.
     * @param persistenceAPI the PersistenceAPI
     */
    BusinessLogicImpl(Persistence persistenceAPI) {
        this.persistenceAPI = persistenceAPI;
    }

    /**
     * Get the implementation of the CustomerManager.
     * @return the implementation of the CustomerManager
     */
    @Override
    public CustomerManager getCustomerManager() {
        return new CustomerManagerImpl(persistenceAPI.getCustomerRepository());
    }
}
