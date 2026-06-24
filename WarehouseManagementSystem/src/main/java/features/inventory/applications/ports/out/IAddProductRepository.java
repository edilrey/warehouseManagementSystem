package features.inventory.applications.ports.out;

import features.inventory.applications.ports.in.IAddProductCommand;

public interface IAddProductRepository {
    public void add(IAddProductCommand command);
}
