package features.inventory.domains.entities;

public class Product {
    private int product_id;
    private String product_name;
    private String status;

    Product(int product_id,
            String product_name,
            String status) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.status = status;
        if (product_name == null || product_name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
    }

    public int getProductId() {
        return product_id;
    }

    public String getProductName() {
        return product_name;
    }

    public String getStatus() {
        return status;
    }

}
