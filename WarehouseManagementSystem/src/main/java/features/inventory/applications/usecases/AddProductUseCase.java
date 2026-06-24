package features.inventory.applications.usecases;

import features.inventory.applications.ports.in.IAddProductCommand;
import features.inventory.applications.ports.in.IAddProductUseCase;
import features.inventory.applications.ports.out.IAddProductOutput;
import features.inventory.applications.ports.out.IAddProductRepository;

public class AddProductUseCase implements IAddProductUseCase {
    private IAddProductRepository addProductRepository;

    public AddProductUseCase(IAddProductRepository addProductRepository) {
        this.addProductRepository = addProductRepository;

    }

    public void execute(IAddProductCommand command, IAddProductOutput presenter) {
        addProductRepository.add(command);
        presenter.presentSuccess(command.getProduct());
    }
}
