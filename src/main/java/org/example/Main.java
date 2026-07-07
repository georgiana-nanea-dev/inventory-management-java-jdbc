package org.example;

import org.example.dao.ProductDAO;
import org.example.model.Product;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {

            System.out.println("\n===== INVENTORY MENU =====");
            System.out.println("1. Add product");
            System.out.println("2. Show all products");
            System.out.println("3. Update product");
            System.out.println("4. Delete product");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                // =====================
                // ADD PRODUCT
                // =====================
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("Quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    Product p = new Product(name, category, price, quantity);
                    dao.addProduct(p);

                    break;

                // =====================
                // SHOW PRODUCTS
                // =====================
                case 2:
                    List<Product> products = dao.getAllProducts();

                    System.out.println("\n--- PRODUCT LIST ---");

                    if (products.isEmpty()) {
                        System.out.println("No products found.");
                    } else {
                        for (Product pr : products) {
                            System.out.println(pr.getId() + " | " + pr.getName() + " | " + pr.getCategory() + " | " + pr.getPrice() + " | " + pr.getQuantity());
                        }
                    }

                    break;

                // =====================
                // UPDATE PRODUCT
                // =====================
                case 3:
                    System.out.print("ID to update: ");
                    int updateId = Integer.parseInt(scanner.nextLine());

                    System.out.print("New name: ");
                    String newName = scanner.nextLine();

                    System.out.print("New category: ");
                    String newCategory = scanner.nextLine();

                    System.out.print("New price: ");
                    double newPrice = Double.parseDouble(scanner.nextLine());

                    System.out.print("New quantity: ");
                    int newQuantity = Integer.parseInt(scanner.nextLine());

                    Product updated = new Product(newName, newCategory, newPrice, newQuantity);
                    updated.setId(updateId);

                    dao.updateProduct(updated);

                    break;

                // =====================
                // DELETE PRODUCT
                // =====================
                case 4:
                    System.out.print("ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());

                    dao.deleteProduct(deleteId);

                    break;

                // =====================
                // EXIT
                // =====================
                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}