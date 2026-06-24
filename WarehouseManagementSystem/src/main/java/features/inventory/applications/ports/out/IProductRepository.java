package features.inventory.applications.ports.out;

import java.util.List;

import features.inventory.domains.entities.Product;

public interface IProductRepository {
    public void add(Product product);

    public void deleteById(String product_id);

    public Product getById(String product_id);

    public List<Product> getAll();
}
