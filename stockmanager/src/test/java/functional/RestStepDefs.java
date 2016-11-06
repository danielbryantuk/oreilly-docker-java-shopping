package functional;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.danielbryant.djshopping.stockmanager.StockManagerApplication;
import uk.co.danielbryant.djshopping.stockmanager.model.Stock;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

@ContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = StockManagerApplication.class)
public class RestStepDefs {

    @Autowired
    private TestRestTemplate restTemplate;

    private List<Stock> stocks;

    @Given("^the application has been initialised with test data$")
    public void init() {
        //the default profile loads synthetic stocks
    }

    @When("^the client gets all stocks$")
    public void getAllStocks() {
        Stock[] stockArray = restTemplate.getForObject("/stocks", Stock[].class);
        stocks = Arrays.asList(stockArray);
    }

    @Then("^a list of (.*) stocks will be returned$")
    public void assertListOfStocksLength(int length) {
        assertThat(stocks, hasSize(length));
    }

    @Then("^the stock at index (.*) will have the sku (.*)$")
    public void assertStockHasSku(int stockIndex, String sku) {
        assertThat(stocks.get(stockIndex).getSku(), is(sku));
    }
}
