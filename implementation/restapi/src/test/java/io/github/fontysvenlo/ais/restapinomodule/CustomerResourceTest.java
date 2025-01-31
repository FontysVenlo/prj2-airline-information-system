package io.github.fontysvenlo.ais.restapinomdule;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(CustomerResource.class)
public class CustomerResourceTest {
//     @Test
//     public void testCustomer() {
//         given()
//             .when()
//                 .post()
//             .then()
//                 .statusCode(200)
//                 .body("$", hasKey("firstName"));
//    }

   @Test
   public void testHello() {
         given()
              .when()
                .get()
              .then()
                .statusCode(200)
                .body(is("HELLO"));
   }
}