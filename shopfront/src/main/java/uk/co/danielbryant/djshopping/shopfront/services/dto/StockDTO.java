package uk.co.danielbryant.djshopping.shopfront.services.dto;

public class StockDTO {
    private String productId;
    private String sku;
    private int amountAvailable;

    public static final StockDTO DEFAULT_STOCK_DTO = new StockDTO("", "default", 999);

    public StockDTO() {
    }

    public StockDTO(String productId, String sku, int amountAvailable) {
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
