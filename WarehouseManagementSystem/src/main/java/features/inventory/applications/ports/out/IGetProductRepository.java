package features.inventory.applications.ports.out;

import java.util.List;

import features.inventory.domains.entities.Product;

public interface IGetProductRepository {
    public Product getById(int product_id);

    public List<Product> getAll();

}
