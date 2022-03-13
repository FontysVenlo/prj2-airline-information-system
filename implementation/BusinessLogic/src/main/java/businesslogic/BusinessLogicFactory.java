package businesslogic;

import persistence.PersistenceAPI;

/**
 * Factory to provide BusinessLogicAPI implementation.
 * 
 * @author Richard van den Ham / Martijn Bonajo
 */
public interface BusinessLogicFactory {
    
    static BusinessLogicAPI getImplementation( PersistenceAPI persistenceAPI ){
        return new BusinessLogicAPIImpl( persistenceAPI );
    }
    
}
