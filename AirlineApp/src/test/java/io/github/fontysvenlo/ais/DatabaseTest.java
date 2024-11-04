package io.github.fontysvenlo.ais;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
class DatabaseTest {
    @Container
    private PostgreSQLContainer<?> postgresqlContainer = new PostgreSQLContainer<>("postgres:latest")
        .withDatabaseName("airline_db")
        .withUsername("user")
        .withPassword("secret")
        .withInitScript("test_db.sql");

    @Test
    void testDbSetup() throws IOException, InterruptedException {
        assertThat(postgresqlContainer.isRunning()).isTrue();

        String tables = postgresqlContainer.execInContainer("psql", "-U", "user", "-d", "airline_db", "-c", "\\dt").getStdout();
        // Note: this is raw output from psql, so it will contain some extra characters
        assertThat(tables).contains("booking");

        String passengerNameOnFirstBooking = postgresqlContainer.execInContainer("psql", "-U", "user", "-d", "airline_db", "-c", "SELECT name FROM passenger WHERE id = (SELECT passenger_id FROM booking LIMIT 1)").getStdout();
        assertThat(passengerNameOnFirstBooking)
            .contains("Alice")
            .doesNotContain("Bob");
    }
}
