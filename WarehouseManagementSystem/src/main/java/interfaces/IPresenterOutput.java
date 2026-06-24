package interfaces;

import features.inventory.domains.entities.Product;

public interface IPresenterOutput {
    void presentSuccess(Product product);

    void presentFailure(String errorMessage);
}
