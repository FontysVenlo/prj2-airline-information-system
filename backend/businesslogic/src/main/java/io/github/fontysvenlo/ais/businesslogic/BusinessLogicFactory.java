package io.github.fontysvenlo.ais.businesslogic;

import io.github.fontysvenlo.ais.businesslogic.api.BusinessLogic;
import io.github.fontysvenlo.ais.persistence.api.Persistence;

/**
 * Factory to provide BusinessLogicAPI implementation.
 */
public class BusinessLogicFactory {
    
    /**
     * Private constructor.
     */
    private BusinessLogicFactory(){
    }

    /**
     * Get the implementation of the BusinessLogic API.
     * @param persistenceAPI the PersistenceAPI
     * @return the implementation of the BusinessLogic API
     */
    public static BusinessLogic getInstance(Persistence persistenceAPI) {
        return new BusinessLogicImpl( persistenceAPI );
    }

}
