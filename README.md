# Inventory Management System

## Project Description

The **Inventory Management System** is a Java console application for managing products in a MySQL database.

The application allows users to add, display, update, and delete products. It demonstrates the use of Java, JDBC, MySQL, and the DAO (Data Access Object) design pattern to separate database logic from the application logic.

This project was created to improve Java backend development skills and database integration.

---

## Technologies

* Java 21
* JDBC
* MySQL
* Maven
* IntelliJ IDEA Community Edition
* XAMPP

---

## Features

* Add new products
* Display all products
* Update existing products
* Delete products
* Store data permanently in a MySQL database
* Console-based user interface

---

## Project Structure

```text
src
└── main
    └── java
        └── org.example
            ├── Main.java
            ├── dao
            │   └── ProductDAO.java
            ├── db
            │   └── DatabaseConnection.java
            └── model
                └── Product.java
```

---

## Database Setup

### 1. Create the database

```sql
CREATE DATABASE inventory_management;
```

### 2. Create the products table

```sql
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(100),
    price DOUBLE,
    quantity INT
);
```

### 3. Configure the database connection

Update the database credentials in:

```text
DatabaseConnection.java
```

Example:

```java
private static final String URL = "jdbc:mysql://localhost:3306/inventory_management";
private static final String USER = "root";
private static final String PASSWORD = "";
```

---

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Start MySQL using XAMPP.
4. Create the database and table.
5. Run `Main.java`.

---

## Future Improvements

* Input validation
* Better exception handling
* Search products
* Sort products
* Export data

---

## Author

**Georgiana Nanea**
