package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseManager {
    private String url;

    public DatabaseManager(String url) {
        this.url = url;
    }

    public void execute() {

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            String sqlCreate = "CREATE TABLE IF NOT EXISTS inventory (id INTEGER PRIMARY KEY, item TEXT, qty INTEGER)";
            stmt.execute(sqlCreate);

            String sqlInsert = "INSERT INTO inventory (item, qty) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
                pstmt.setString(1, "Laptop");
                pstmt.setInt(2, 50);
                pstmt.executeUpdate();
            }

            String sqlSelect = "SELECT id, item, qty FROM inventory";
            try (ResultSet rs = stmt.executeQuery(sqlSelect)) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("item") + " " + rs.getInt("qty"));
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}