package features.inventory.applications.usecases;

import java.util.List;

import features.inventory.applications.ports.out.IProductRepository;
import features.inventory.domains.entities.Product;

public class GetAllProductsUseCase {
    private final IProductRepository productRepo;

    public GetAllProductsUseCase(IProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> execute() {
        return productRepo.getAll();
    }

}
