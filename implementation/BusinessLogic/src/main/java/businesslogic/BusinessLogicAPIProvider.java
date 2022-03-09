package businesslogic;

import persistence.PersistenceAPI;

/**
 * Interface to provide the BusinessLogicAPI to outside layers
 * 
 * @author m.bonajo@fontys.nl
 */
public interface BusinessLogicAPIProvider extends BusinessLogicAPI {
    
    /**
     * Get concrete BusinessLocigAPI
     * @param persistenceAPI needed to pass to the managers
     * @return BusinessLocigAPI 
     */
    static BusinessLogicAPI getBusinessLogic(PersistenceAPI persistenceAPI){
        return new BusinessLogicAPIImpl(persistenceAPI);
    }
}
