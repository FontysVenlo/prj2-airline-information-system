package io.github.fontysvenlo.ais.persistence;

/**
 * Actual creator of storage services.
 */
class PersistenceAPIImpl implements PersistenceAPI{

    /**
     * Get the implementation of the CustomerStorageService.
     * @return the implementation of the CustomerStorageService
     */
    @Override
    public CustomerStorageService getCustomerStorageService() {
        return new CustomerStorageServiceImpl();
    }
}
