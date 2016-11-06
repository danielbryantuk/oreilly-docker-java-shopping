package uk.co.danielbryant.djshopping.stockmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.co.danielbryant.djshopping.stockmanager.model.Stock;

public interface StockRepository extends CrudRepository<Stock, String> {
}
