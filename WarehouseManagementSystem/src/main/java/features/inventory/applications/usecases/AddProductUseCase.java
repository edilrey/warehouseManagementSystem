package features.inventory.applications.usecases;

import features.inventory.applications.ports.out.IProductRepository;
import features.inventory.domains.entities.Product;
import interfaces.IPresenterOutput;

public class AddProductUseCase {
    private IProductRepository productRepo;

    public AddProductUseCase(IProductRepository productRepo) {
        this.productRepo = productRepo;

    }

    public void execute(Product product, IPresenterOutput presenter) {
        productRepo.add(product);
        presenter.presentSuccess(product);
    }
}
