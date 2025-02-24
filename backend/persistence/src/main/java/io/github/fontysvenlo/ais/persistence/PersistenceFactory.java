package io.github.fontysvenlo.ais.persistence;

import io.github.fontysvenlo.ais.persistence.api.Persistence;

/**
 * Factory to provide PersistenceAPI implementation.
 */
public class PersistenceFactory {
    
    /**
     * Private constructor.
     */
    private PersistenceFactory() {
    }

    /**
     * Get the implementation of the Persistence API.
     * @param config the configuration of the database
     * @return the implementation of the Persistence API
     */
    public static Persistence getInstance(DBConfig config) {
        return new PersistenceImpl(config);
    }
}
