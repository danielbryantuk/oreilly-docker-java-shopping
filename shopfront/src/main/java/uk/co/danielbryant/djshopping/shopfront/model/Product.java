package uk.co.danielbryant.djshopping.shopfront.model;

import java.math.BigDecimal;

public class Product {
    private String id;
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private int amountAvailable;

    public Product(String id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String id, String sku, String name, String description, BigDecimal price, int amountAvailable) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountAvailable = amountAvailable;
    }

    public String getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }
}
