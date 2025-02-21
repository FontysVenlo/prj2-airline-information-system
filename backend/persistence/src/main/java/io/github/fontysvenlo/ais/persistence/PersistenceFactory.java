package io.github.fontysvenlo.ais.persistence;

/**
 * Factory to provide PersistenceAPI implementation.
 */
public interface PersistenceFactory {
    /**
     * Get the implementation of the PersistenceAPI.
     * @param config the configuration of the database
     * @return the implementation of the PersistenceAPI
     */
    static PersistenceAPI getImplementation(DBConfig config) {
        return new PersistenceAPIImpl(config);
    }
}
