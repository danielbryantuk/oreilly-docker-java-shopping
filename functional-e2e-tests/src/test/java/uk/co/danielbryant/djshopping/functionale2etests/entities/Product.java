package uk.co.danielbryant.djshopping.functionale2etests.entities;

import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer amountAvailable;


    public Product() {
    }

    public Product(Integer id, String sku, String name, String description, BigDecimal price, Integer amountAvailable) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountAvailable = amountAvailable;
    }

    public Integer getId() {
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

    public Integer getAmountAvailable() {
        return amountAvailable;
    }
}
