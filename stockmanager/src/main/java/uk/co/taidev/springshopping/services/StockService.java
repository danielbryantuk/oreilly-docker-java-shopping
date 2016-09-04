package uk.co.taidev.springshopping.services;

import org.springframework.stereotype.Service;
import uk.co.taidev.springshopping.exceptions.StockNotFoundException;
import uk.co.taidev.springshopping.model.Stock;

import java.util.*;

@Service
public class StockService {

    //{productId, Stock}
    private Map<String, Stock> fakeStockDAO = new HashMap<>();

    public StockService() {
        fakeStockDAO.put("1", new Stock("1", "12345678", 5));
        fakeStockDAO.put("2", new Stock("2", "34567890", 2));
        fakeStockDAO.put("3", new Stock("3", "54326745", 999));
        fakeStockDAO.put("4", new Stock("4", "93847614", 0));
        fakeStockDAO.put("5", new Stock("5", "11856388", 1));
    }

    public List<Stock> getStocks() {
        return new ArrayList<>(fakeStockDAO.values());
    }

    public Stock getStock(String productId) throws StockNotFoundException {
        return Optional.ofNullable(fakeStockDAO.get(productId))
                .orElseThrow(() -> new StockNotFoundException("Stock not found with productId: " + productId));
    }
}
