package features.inventory.domains.entities;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private String status;

    Product(UUID id,
            String name,
            String status) {
        this.id = id;
        this.name = name;
        this.status = status;
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
    }

    public UUID getProductId() {
        return id;
    }

    public String getProductName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

}
