package io.github.fontysvenlo.ais.persistence;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import static org.assertj.core.api.Assertions.*;

import io.github.fontysvenlo.ais.datarecords.CustomerData;

/**
 * This example test is testing the persistency layer including a test database in a container.
 *
 * When you start setting up your database and persistence layer, this is a good place to start.
 * You will need to add some database setup and can prefill the database with some data before a test.
 */
public class PersistenceIntegrationTest {
    private static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");
    private static DBConfig config;

    @BeforeAll
    static void beforeAll() {
        postgres.start();
        config = new DBConfig("test", postgres.getHost(), postgres.getFirstMappedPort(), "test", "ais", "test", "test");
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @BeforeEach
    void setUp() {}

    @Test
    void testAddingAndRetrievingCustomers() {
        // Arrange
        PersistenceAPI persistenceAPI = PersistenceFactory.getImplementation(config);
        CustomerStorageService customerStorageService = persistenceAPI.getCustomerStorageService();

        // Act
        customerStorageService.add(new CustomerData(0, "John", "Doe", LocalDate.of(2025, 1, 1)));
        List<CustomerData> customers = customerStorageService.getAll();

        // Assert
        // Note: this assumes that the database was empty before the test.
        // The intention of the test is to make sure that if we store a customer, we can retrieve it.
        assertThat(customers).hasSize(1);
        assertThat(customers.get(0).firstName()).isEqualTo("John");
    }
}
