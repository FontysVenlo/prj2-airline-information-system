package io.github.fontysvenlo.ais.businesslogic;

import io.github.fontysvenlo.ais.persistence.PersistenceAPI;

/**
 * Factory to provide BusinessLogicAPI implementation.
 *
 * @author Informatics Fontys Venlo
 */
public interface BusinessLogicFactory {

    static BusinessLogicAPI getImplementation( PersistenceAPI persistenceAPI ){
        return new BusinessLogicAPIImpl( persistenceAPI );
    }

}
