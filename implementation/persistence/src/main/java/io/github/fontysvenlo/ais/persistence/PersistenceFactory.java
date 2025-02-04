package io.github.fontysvenlo.ais.persistence;

/**
 * Factory to provide PersistenceAPI implementation.
 */
public interface PersistenceFactory {

    /**
     * Get the implementation of the PersistenceAPI.
     * @return the implementation of the PersistenceAPI
     */
    static PersistenceAPI getImplementation(){
        return new PersistenceAPIImpl();
    }

}
