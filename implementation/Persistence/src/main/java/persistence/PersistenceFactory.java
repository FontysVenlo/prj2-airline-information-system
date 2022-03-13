package persistence;

/**
 * Factory to provide PersistenceAPI implementation.
 * @author Richard van den Ham / Martijn Bonajo
 */
public interface PersistenceFactory {
    
    static PersistenceAPI getImplementation(){
        return new PersistenceAPIImpl();
    }
    
}
