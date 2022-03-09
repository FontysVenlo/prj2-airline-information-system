package persistence;

/**
 * Interface that gives access to the persistance API
 * 
 * @author m.bonajo@fontys.nl
 */
public interface PersistenceAPIProvider extends PersistenceAPI {
    
    /**
     * Give access to the persistence API
     * 
     * @return PersistenceAPI
     */
    static PersistenceAPI getPersistenceAPI() {
        return new PersistenceAPIImpl();
    }
    
}
