package io.github.fontysvenlo.ais.persistence;

/**
 * Factory to provide PersistenceAPI implementation.
 * @author Informatics Fontys Venlo
 */
public interface PersistenceFactory {

    static PersistenceAPI getImplementation(){
        return new PersistenceAPIImpl();
    }

}
