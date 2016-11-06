package uk.co.danielbryant.djshopping.shopfront.repo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import uk.co.danielbryant.djshopping.shopfront.services.dto.StockDTO;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class StockRepo {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockRepo.class);

    @Value("${stockManagerUri}")
    private String stockManagerUri;

    @Autowired
    @Qualifier(value = "stdRestTemplate")
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "stocksNotFound") // Hystrix circuit breaker for fault-tolernace demo
    public Map<String, StockDTO> getStockDTOs() {
        LOGGER.info("getStocksDTOs");
        ResponseEntity<List<StockDTO>> stockManagerResponse =
                restTemplate.exchange(stockManagerUri + "/stocks",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<StockDTO>>() {
                        });
        List<StockDTO> stockDTOs = stockManagerResponse.getBody();

        return stockDTOs.stream()
                .collect(Collectors.toMap(StockDTO::getProductId, Function.identity()));
    }

    public Map<String, StockDTO> stocksNotFound() {
        LOGGER.info("stocksNotFound *** FALLBACK ***");
        return Collections.EMPTY_MAP;
    }
}
