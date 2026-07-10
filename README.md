# Inventory Management System

## Project Description

The Inventory Management System is a Java console application for managing product data stored in a MySQL database.

The application provides CRUD operations:

* Create products
* Read product information
* Update existing products
* Delete products

This project demonstrates Java backend development using JDBC, MySQL, Maven, and the DAO (Data Access Object) design pattern to separate database operations from application logic.

The goal of this project was to improve practical skills in Java programming, database integration, SQL, and software project organization.

---

## Technologies

* Java 21
* JDBC
* MySQL
* Maven
* IntelliJ IDEA Community Edition
* XAMPP
* Git
* GitHub

---

## Features

* Add new products
* Display all products
* Update existing products
* Delete products
* Store data permanently in a MySQL database
* Console-based user interface
* Input validation
* Database error handling

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
CREATE DATABASE inventory_db;
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

### 3. Configure database connection

Update the database credentials in:

```text
DatabaseConnection.java
```

Example:

```java
private static final String URL =
"jdbc:mysql://localhost:3306/inventory_db";

private static final String USER = "root";

private static final String PASSWORD = "";
```

---

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Start MySQL using XAMPP.
4. Create the database and products table.
5. Configure the database connection.
6. Run `Main.java`.
7. Use the console menu to manage products.

---

## Screenshots

Add screenshots of the application here:

* Application menu
* Product list
* Project structure

Example:

```text
screenshots/
├── menu.png
├── products.png
└── project-structure.png
```

---

## Future Improvements

Possible future improvements:

* Search products
* Sort products
* Export data
* Graphical User Interface (JavaFX)
* User authentication
* Advanced database queries

---

## Author

Georgiana Nanea
