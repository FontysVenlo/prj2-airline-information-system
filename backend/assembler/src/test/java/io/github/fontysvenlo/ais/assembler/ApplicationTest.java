package io.github.fontysvenlo.ais.assembler;

import java.util.List;

import io.github.fontysvenlo.ais.persistence.DBConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

import io.github.fontysvenlo.ais.datarecords.CustomerData;
import io.github.fontysvenlo.ais.restapi.ServerConfig;

/**
 * This example test is testing the whole backend, including a test database.
 * (Even though the test database is not used yet.)
 * We do inject our own configuration objects rather than reading them from properties files.
 *
 * We use Rest Assured to write the integrated tests, which allows us to use Given-When-Then.
 *
 */
public class ApplicationTest {
    private static final int PORT = 8080;
    private static final int CORS = 5173;

    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
        .withDatabaseName("test")
        .withUsername("test")
        .withPassword("test");

    private static Thread serverThread;

    @BeforeAll
    static void beforeAll() {
        // Start the database container
        postgres.start();

        // Start the assembler in a separate thread
        DBConfig dbConfig = new DBConfig("test", postgres.getHost(), postgres.getFirstMappedPort(), "test", "ais", "test", "test");
        ServerConfig serverConfig = new ServerConfig(PORT, CORS);
        serverThread = new Thread(() -> Assembler.start(dbConfig, serverConfig));
        serverThread.start();
        org.testcontainers.Testcontainers.exposeHostPorts(serverConfig.port());
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();

        serverThread.interrupt();
    }

    @BeforeEach
    void setUp() {}

    @Test
    void testRetrievingInitialCustomersList() {
        List<CustomerData> customers = given()
            .when()
                .get("http://localhost:" + PORT + "/api/v1/customers")
            .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("", CustomerData.class);

        // Based on your test database, you might have different expectations / valid scenarios
        assertThat(customers).isEmpty();
    }
}
