package features.inventory.applications.ports.in;

import features.inventory.domains.entities.Product;

public record IAddProductCommand(Product product) {
    public IAddProductCommand {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
    }

}
