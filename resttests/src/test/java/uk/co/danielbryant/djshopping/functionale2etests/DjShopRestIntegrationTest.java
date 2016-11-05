package uk.co.danielbryant.djshopping.functionale2etests;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class DjShopRestIntegrationTest {

    private static final ContentType CONTENT_TYPE = ContentType.JSON;
    private static final String SUT_BASE_URI = "http://localhost:8010/";

    @Test
    public void correctNumberOfProductsReturned() {
        given().contentType(CONTENT_TYPE)
                .when()
                .get(SUT_BASE_URI + "products")
                .then()
                .body("size()", is(5));
    }

    @Test
    public void productOneHasCorrectProductInfo() {
        given().contentType(CONTENT_TYPE)
                .when()
                .get(SUT_BASE_URI + "products")
                .then()
                .body("[0].id", is("1"))
                .body("[0].sku", is("12345678"));
    }

    @Test
    public void productOneHasCorrectStockInfo() {
        given()
                .contentType(CONTENT_TYPE)
                .when()
                .get(SUT_BASE_URI + "products")
                .then()
                .body("[0].amountAvailable", is(5));
    }
}
