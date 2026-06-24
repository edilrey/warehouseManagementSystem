package features.inventory.applications.usecases;

import features.inventory.applications.ports.out.IProductRepository;

public class EditProductByIdUseCase {
    private IProductRepository productRepo;

    public EditProductByIdUseCase(IProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public void execute(String id, String name, String status, int quantity) {
        productRepo.editById(id, name, status, quantity);
    }
}
