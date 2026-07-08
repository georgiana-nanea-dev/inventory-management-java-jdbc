package org.example.dao;

import org.example.db.DatabaseConnection;
import org.example.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // =========================
    // CREATE - Produkt speichern
    // =========================
    public void addProduct(Product product) {

        String sql = "INSERT INTO products (name, category, price, quantity) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getCategory());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Product saved successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Database error while inserting: " + e.getMessage());
        }
    }


    // =========================
    // READ - Alle Produkte holen
    // =========================
    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();

        String sql = """
                SELECT id, name, category, price, quantity
                FROM products
                ORDER BY id
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {


            while (rs.next()) {

                Product product = new Product();

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));

                products.add(product);
            }

        } catch (SQLException e) {
            System.out.println("Database error while reading: " + e.getMessage());
        }

        return products;
    }


    // =========================
    // CHECK - Existiert Produkt?
    // =========================
    public boolean existsById(int id) {

        String sql = "SELECT id FROM products WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {

            System.out.println("Database error while checking ID: " + e.getMessage());
            return false;
        }
    }


    // =========================
    // UPDATE - Produkt ändern
    // =========================
    public void updateProduct(Product product) {

        String sql = """
                UPDATE products
                SET name=?, category=?, price=?, quantity=?
                WHERE id=?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, product.getName());
            stmt.setString(2, product.getCategory());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.setInt(5, product.getId());


            int rows = stmt.executeUpdate();


            if (rows > 0) {

                System.out.println("Product updated successfully!");

            } else {

                System.out.println("No product found with this ID.");
            }


        } catch (SQLException e) {

            System.out.println("Database error while updating: " + e.getMessage());
        }
    }


    // =========================
    // DELETE - Produkt löschen
    // =========================
    public void deleteProduct(int id) {

        String sql = "DELETE FROM products WHERE id=?";


        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();


            if (rows > 0) {

                System.out.println("Product deleted successfully!");

            } else {

                System.out.println("No product found with this ID.");
            }


        } catch (SQLException e) {

            System.out.println("Database error while deleting: " + e.getMessage());
        }
    }
}