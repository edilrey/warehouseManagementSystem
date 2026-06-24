
import features.inventory.infrastructure.InventoryController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Warehouse Management System!");
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        InventoryController inventoryController = new InventoryController();
    }
}
