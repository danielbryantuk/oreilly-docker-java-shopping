package uk.co.taidev.springshopping.model;

public class Stock {

    private String productId;
    private String sku;
    private int amountAvailable;

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
