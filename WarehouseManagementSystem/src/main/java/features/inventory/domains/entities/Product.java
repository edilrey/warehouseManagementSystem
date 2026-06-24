package features.inventory.domains.entities;

import java.util.UUID;
import features.inventory.domains.ProductStatusEnum;

public class Product {
    private UUID id;
    private String name;
    private String status;
    private int quantity;

    public Product(UUID id,
            String name,
            String status,
            int quantity) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.quantity = quantity;
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
        if (!status.equals(ProductStatusEnum.AVAILABLE) && !status.equals(ProductStatusEnum.UNAVAILABLE)) {
            throw new IllegalArgumentException("Status must be either 'available' or 'unavailable'");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getQuantity() {
        return quantity;
    }

}
