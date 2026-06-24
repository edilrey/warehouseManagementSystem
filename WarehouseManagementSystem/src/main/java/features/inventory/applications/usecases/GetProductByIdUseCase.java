package features.inventory.applications.usecases;

import features.inventory.applications.ports.out.IProductRepository;
import features.inventory.domains.entities.Product;
import java.util.UUID;

public class GetProductByIdUseCase {
    private final IProductRepository productRepo;

    public GetProductByIdUseCase(IProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public Product execute(UUID product_id) {
        return productRepo.getById(product_id);
    }
}
