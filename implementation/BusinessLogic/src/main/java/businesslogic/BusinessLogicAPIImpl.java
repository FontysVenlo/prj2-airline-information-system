package businesslogic;

import persistence.PersistenceAPI;

/**
 * Implementation of the CustomerManagerAPI
 * 
 * @author m.bonajo@fontys.nl
 */
class BusinessLogicAPIImpl implements BusinessLogicAPIProvider {
   
    private final PersistenceAPI persistenceAPI;

    /**
     * Create new BusinessLogicAPI to retrieve supported managers
     * 
     * @param persistenceAPI the persistenceAPI needed to let managers
     * interact with the persistence layer
     */
    public BusinessLogicAPIImpl(PersistenceAPI persistenceAPI) {
        this.persistenceAPI = persistenceAPI;
    }

    @Override
    public CustomerManager getCustomerManager() {
        return new CustomerManager(persistenceAPI.getCustomerStorage());
    }
    
    
    
}
