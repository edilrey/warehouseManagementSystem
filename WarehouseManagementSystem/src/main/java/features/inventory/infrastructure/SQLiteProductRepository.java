package features.inventory.infrastructure;

import features.inventory.applications.ports.out.IProductRepository;
import features.inventory.domains.entities.Product;
import java.util.List;
import java.util.UUID;
import java.sql.*;
import features.inventory.domains.ProductStatusEnum;

public class SQLiteProductRepository implements IProductRepository {
    private String url;

    public SQLiteProductRepository(String url) {
        this.url = url;
    }

    public void add(Product product) {
        String sqlInsert = "INSERT INTO inventory (id, item, qty) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
            pstmt.setString(1, product.getId().toString());
            pstmt.setString(2, product.getName());
            pstmt.setInt(3, product.getQuantity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error adding product to the database", e);
        }

    }

    public void deleteById(UUID product_id) {
        String sqlDelete = "DELETE FROM inventory WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {
            pstmt.setString(1, product_id.toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error deleting product from the database", e);
        }

    }

    public void editById(String id, String name, String status, int quantity) {
        String sqlUpdate = "UPDATE inventory SET item = ?, qty = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, quantity);
            pstmt.setString(3, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Product not found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error updating product in the database", e);
        }
    }

    public Product getById(UUID product_id) {
        String sqlSelect = "SELECT id, item, qty FROM inventory WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sqlSelect)) {
            pstmt.setString(1, product_id.toString());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                String name = rs.getString("item");
                int quantity = rs.getInt("qty");
                return new Product(id, name, ProductStatusEnum.AVAILABLE, quantity);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error retrieving product from the database", e);
        }
        throw new RuntimeException("Product not found");
    }

    public List<Product> getAll() {
        String sqlSelectAll = "SELECT id, item, qty FROM inventory";
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sqlSelectAll)) {
            List<Product> products = new java.util.ArrayList<>();
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                String name = rs.getString("item");
                int quantity = rs.getInt("qty");
                products.add(new Product(id, name, ProductStatusEnum.AVAILABLE, quantity));
            }
            return products;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error retrieving products from the database", e);
        }
    }
}
