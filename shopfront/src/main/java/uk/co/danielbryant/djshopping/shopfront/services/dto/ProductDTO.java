package uk.co.danielbryant.djshopping.shopfront.services.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(String id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
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
}
