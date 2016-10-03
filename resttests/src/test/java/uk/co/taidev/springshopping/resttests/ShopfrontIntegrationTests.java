package uk.co.taidev.springshopping.resttests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.junit.Test;
import uk.co.taidev.springshopping.resttests.entities.Product;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

public class ShopfrontIntegrationTests {

    private static final ContentType CONTENT_TYPE = ContentType.JSON;

    private static final String BASE_TEST_URI = "http://localhost:8010/";

    @Test
    public void assertCorrectNumberOfProductsReturned() {
        List<Product> products = new ArrayList<Product>();
        products = given()
                .contentType(CONTENT_TYPE)
                .when()
                .get(BASE_TEST_URI + "products")
                .then()
                .extract().body().as(products.getClass());

        assertThat(products, hasSize(5));
    }

    @Test
    public void assertFirstProductContainsCorrectData() {
        List<Product> products = new ArrayList<Product>();
        products = given()
                .contentType(CONTENT_TYPE)
                .when()
                .get(BASE_TEST_URI + "products")
                .then()
                .extract().body().as(products.getClass());

        ObjectMapper mapper = new ObjectMapper();
        Product firstProduct = mapper.convertValue(products.get(0), Product.class);

        assertThat(firstProduct.getId(), is(1));
        assertThat(firstProduct.getSku(), is("12345678"));
    }
}
