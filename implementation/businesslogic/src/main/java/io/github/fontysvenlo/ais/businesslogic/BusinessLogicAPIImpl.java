package io.github.fontysvenlo.ais.businesslogic;

import io.github.fontysvenlo.ais.persistence.PersistenceAPI;
import io.github.fontysvenlo.ais.persistence.CustomerStorageService;

/**
 * Actual business logic implementation.
 *
 * @author Informatics Fontys Venlo
 */
class BusinessLogicAPIImpl implements BusinessLogicAPI {

    final PersistenceAPI persistenceAPI;

    BusinessLogicAPIImpl(PersistenceAPI persistenceAPI) {
        this.persistenceAPI = persistenceAPI;
    }

    @Override
    public CustomerManager getCustomerManager() {
        return new CustomerManager(persistenceAPI.getCustomerStorageService());
    }

}
