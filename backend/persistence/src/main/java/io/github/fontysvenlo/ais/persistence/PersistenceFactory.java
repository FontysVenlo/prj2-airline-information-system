package io.github.fontysvenlo.ais.persistence;

import io.github.fontysvenlo.ais.persistence.api.PersistenceAPI;

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
