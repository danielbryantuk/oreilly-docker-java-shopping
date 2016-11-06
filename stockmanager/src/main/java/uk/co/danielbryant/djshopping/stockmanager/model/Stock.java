package uk.co.danielbryant.djshopping.stockmanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {

    @Id
    private String productId;
    private String sku;
    private int amountAvailable;

    protected Stock() {
    }

    public Stock(String productId, String sku, int amountAvailable) {
        this.productId = productId;
        this.sku = sku;
        this.amountAvailable = amountAvailable;
    }

    public String getProductId() {
        return productId;
    }

    public String getSku() {
        return sku;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }
}
