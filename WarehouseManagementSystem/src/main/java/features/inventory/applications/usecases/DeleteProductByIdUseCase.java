package features.inventory.applications.usecases;

import java.util.UUID;

import features.inventory.applications.ports.out.IProductRepository;

public class DeleteProductByIdUseCase {
    private IProductRepository productRepo;

    public DeleteProductByIdUseCase(IProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public void execute(UUID productId) {
        productRepo.deleteById(productId);
    }

}
