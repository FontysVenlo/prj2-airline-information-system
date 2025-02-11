package io.github.fontysvenlo.ais.persistence;

/**
 * Actual creator of storage services.
 */
class PersistenceAPIImpl implements PersistenceAPI{
    private DBConfig config;

    PersistenceAPIImpl(DBConfig config) {
        this.config = config;
    }

    /**
     * Get the implementation of the CustomerRepository.
     * @return the implementation of the CustomerRepository
     */
    @Override
    public CustomerRepository getCustomerRepository() {
        return new CustomerRepositoryImpl(config);
    }
}
