package org.example.dao;

import org.example.db.DatabaseConnection;
import org.example.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

            stmt.executeUpdate();

            System.out.println("Product saved successfully!");

        } catch (Exception e) {
            System.out.println("Error (INSERT): " + e.getMessage());
        }
    }


    // =========================
    // READ - Alle Produkte holen
    // =========================
    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM products";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Product p = new Product();

                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));

                products.add(p);
            }

        } catch (Exception e) {
            System.out.println("Error (SELECT): " + e.getMessage());
        }

        return products;
    }


    // =========================
    // UPDATE - Produkt ändern
    // =========================
    public void updateProduct(Product product) {

        String sql = "UPDATE products SET name=?, category=?, price=?, quantity=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getCategory());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.setInt(5, product.getId());

            stmt.executeUpdate();

            System.out.println("Product updated successfully!");

        } catch (Exception e) {
            System.out.println("Error (UPDATE): " + e.getMessage());
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

            stmt.executeUpdate();

            System.out.println("Product deleted successfully!");

        } catch (Exception e) {
            System.out.println("Error (DELETE): " + e.getMessage());
        }
    }
}