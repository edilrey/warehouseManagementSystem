package features.inventory.applications.ports.out;

import features.inventory.domains.entities.Product;

public interface IAddProductOutput {
    void presentSuccess(Product product);

    void presentFailure(String errorMessage);
}
