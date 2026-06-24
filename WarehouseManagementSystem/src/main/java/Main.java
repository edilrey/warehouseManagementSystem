
import features.inventory.infrastructure.InventoryController;
import db.DatabaseManager;
import features.inventory.infrastructure.SQLiteProductRepository;
import features.inventory.applications.usecases.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Warehouse Management System!");
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:warehouse.db";
        DatabaseManager databaseManager = new DatabaseManager(url);
        databaseManager.execute();

        SQLiteProductRepository productRepository = new SQLiteProductRepository(url);
        AddProductUseCase addProductUseCase = new AddProductUseCase(productRepository);
        DeleteProductByIdUseCase deleteProductUseCase = new DeleteProductByIdUseCase(productRepository);
        EditProductByIdUseCase editProductByIdUseCase = new EditProductByIdUseCase(productRepository);
        GetProductByIdUseCase getProductByIdUseCase = new GetProductByIdUseCase(productRepository);
        GetAllProductsUseCase getAllProductsUseCase = new GetAllProductsUseCase(productRepository);

        InventoryController inventoryController = new InventoryController(addProductUseCase,
                editProductByIdUseCase, deleteProductUseCase, getProductByIdUseCase, getAllProductsUseCase);
    }
}
