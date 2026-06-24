package features.inventory.infrastructure;

import features.inventory.applications.usecases.AddProductUseCase;
import features.inventory.applications.usecases.DeleteProductByIdUseCase;
import features.inventory.applications.usecases.EditProductByIdUseCase;
import features.inventory.applications.usecases.GetAllProductsUseCase;
import features.inventory.applications.usecases.GetProductByIdUseCase;

public class InventoryController {

    public InventoryController(AddProductUseCase addProductUseCase, EditProductByIdUseCase editProductByIdUseCase,
            DeleteProductByIdUseCase deleteProductByIdUseCase, GetProductByIdUseCase getProductByIdUseCase,
            GetAllProductsUseCase getAllProductsUseCase) {
    }

}