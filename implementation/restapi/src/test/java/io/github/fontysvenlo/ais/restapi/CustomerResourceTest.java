package io.github.fontysvenlo.ais.restapi;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import io.github.fontysvenlo.ais.datarecords.CustomerData;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
@TestHTTPEndpoint(CustomerResource.class)
public class CustomerResourceTest {
    @Test
    public void testAddNewCustomer201() {
        given()
          .contentType(ContentType.JSON)
          .body(new CustomerData(0, "John", "Doe", LocalDate.of(2025, 1, 1)))
        .when()
            .post()
        .then()
            .statusCode(201)
            .body("$", hasKey("firstName"));
   }

   @Test
   public void testAddingEmptyCustomer400() {
        given()
          .contentType(ContentType.JSON)
          .body("")
        .when()
            .post()
        .then()
            .statusCode(400);
   }
}
