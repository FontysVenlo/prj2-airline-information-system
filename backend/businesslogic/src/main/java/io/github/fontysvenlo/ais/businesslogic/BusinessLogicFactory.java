package io.github.fontysvenlo.ais.businesslogic;

import io.github.fontysvenlo.ais.persistence.api.PersistenceAPI;

/**
 * Factory to provide BusinessLogicAPI implementation.
 */
public interface BusinessLogicFactory {
    /**
     * Get the implementation of the BusinessLogicAPI.
     * @param persistenceAPI the PersistenceAPI
     * @return the implementation of the BusinessLogicAPI
     */
    static BusinessLogicAPI getImplementation( PersistenceAPI persistenceAPI ){
        return new BusinessLogicAPIImpl( persistenceAPI );
    }

}
