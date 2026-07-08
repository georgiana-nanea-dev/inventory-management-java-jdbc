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

            System.out.println("\n==============================");
            System.out.println("      INVENTORY MENU");
            System.out.println("==============================");
            System.out.println("1. Add Product");
            System.out.println("2. Show All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("0. Exit");

            int choice = readInt(scanner, "Choose: ");

            switch (choice) {

                // =====================
                // ADD PRODUCT
                // =====================
                case 1:

                    String name = readText(scanner, "Name: ");
                    String category = readText(scanner, "Category: ");
                    double price = readDouble(scanner, "Price: ");
                    int quantity = readPositiveInt(scanner, "Quantity: ");

                    Product product = new Product(name, category, price, quantity);
                    dao.addProduct(product);

                    break;

                // =====================
                // SHOW PRODUCTS
                // =====================
                case 2:

                    List<Product> products = dao.getAllProducts();

                    System.out.println("\n---------------- PRODUCT LIST ----------------");

                    if (products.isEmpty()) {

                        System.out.println("No products found.");

                    } else {

                        System.out.printf("%-5s %-20s %-15s %-10s %-10s%n",
                                "ID", "NAME", "CATEGORY", "PRICE", "QUANTITY");

                        System.out.println("--------------------------------------------------------------");

                        for (Product p : products) {

                            System.out.printf("%-5d %-20s %-15s %-10.2f %-10d%n",
                                    p.getId(),
                                    p.getName(),
                                    p.getCategory(),
                                    p.getPrice(),
                                    p.getQuantity());
                        }
                    }

                    break;

                // =====================
                // UPDATE PRODUCT
                // =====================
                case 3:

                    int updateId = readPositiveInt(scanner, "ID to update: ");

                    if (!dao.existsById(updateId)) {

                        System.out.println("No product found with this ID.");
                        break;
                    }


                    String newName = readText(scanner, "New name: ");
                    String newCategory = readText(scanner, "New category: ");
                    double newPrice = readDouble(scanner, "New price: ");
                    int newQuantity = readPositiveInt(scanner, "New quantity: ");


                    Product updatedProduct =
                            new Product(newName, newCategory, newPrice, newQuantity);

                    updatedProduct.setId(updateId);


                    dao.updateProduct(updatedProduct);

                    break;

                // =====================
                // DELETE PRODUCT
                // =====================
                case 4:

                    int deleteId = readPositiveInt(scanner, "ID to delete: ");

                    if (!dao.existsById(deleteId)) {

                        System.out.println("No product found with this ID.");
                        break;
                    }

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

                    System.out.println("Invalid menu option.");
            }
        }
    }

    // =====================
    // Read Integer
    // =====================
    private static int readInt(Scanner scanner, String message) {

        while (true) {

            try {

                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }
        }
    }

    // =====================
    // Read Positive Integer
    // =====================
    private static int readPositiveInt(Scanner scanner, String message) {

        while (true) {

            int value = readInt(scanner, message);

            if (value >= 0) {
                return value;
            }

            System.out.println("Value cannot be negative.");
        }
    }

    // =====================
    // Read Double
    // =====================
    private static double readDouble(Scanner scanner, String message) {

        while (true) {

            try {

                System.out.print(message);

                double value = Double.parseDouble(scanner.nextLine());

                if (value < 0) {

                    System.out.println("Value cannot be negative.");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }
        }
    }

    // =====================
    // Read Text
    // =====================
    private static String readText(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            String text = scanner.nextLine().trim();

            if (!text.isEmpty()) {
                return text;
            }

            System.out.println("Input cannot be empty.");
        }
    }
}