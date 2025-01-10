package restapi;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasKey;


@QuarkusTest
public class CustomerResourceTest {
    @Test
    public void testCustomer() {
        given()
            .when()
                .post("/customers")
            .then()
                .statusCode(200)
                .body("$", hasKey("firstName"));
   }
}