package features.inventory.applications.ports.in;

import features.inventory.applications.ports.out.IAddProductOutput;

public interface IAddProductUseCase {
    public void execute(IAddProductCommand command, IAddProductOutput presenter);
}