package uk.co.taidev.springshopping.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.co.taidev.springshopping.model.Stock;

public interface StockRepository extends CrudRepository<Stock, String> {
}
