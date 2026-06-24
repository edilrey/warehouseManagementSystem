package features.inventory.applications.ports.out;

import java.util.List;

import features.inventory.domains.entities.Product;
import java.util.UUID;

public interface IProductRepository {
    public void add(Product product);

    public void deleteById(UUID product_id);

    public Product getById(UUID product_id);

    public List<Product> getAll();
}
