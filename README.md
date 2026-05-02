# Lost and Found Item Management System

A desktop-based **Lost and Found Item Management System** built using **Java Swing**, **JDBC**, and **MySQL**.
The application provides a graphical interface to manage lost and found items efficiently while following a clean layered architecture.

---

## Features

* Add lost or found items through GUI
* View all records in a table (JTable)
* Delete item records by ID
* Fetch item details by ID *(backend ready)*
* Update item status *(backend ready)*
* Input validation through service layer

---

## Tech Stack

* Java (Swing)
* JDBC
* MySQL
* SQL

---

## Project Structure

```id="lf1"
Lost-And-Found-System/
│
├── src/
│   ├── dao/        → database interaction (JDBC)
│   ├── dto/        → item data model
│   ├── service/    → business logic & validation
│   ├── ui/         → Swing GUI
│   └── mysql-connector-j-9.x.x.jar
│
├── .gitignore
└── README.md
```

---

## Architecture Overview

The project follows a layered architecture to ensure clear separation of responsibilities:

* **DTO** – represents item details (name, description, status, etc.)
* **DAO** – handles database operations using JDBC
* **Service** – manages validation and business rules
* **UI** – provides a graphical interface for user interaction

---

## Database Setup

```sql id="lf2"
CREATE DATABASE rnsitdb;
USE rnsitdb;

CREATE TABLE items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(100),
    description VARCHAR(255),
    status VARCHAR(50)  -- Lost / Found
);
```

---

## Running the Project

1. Ensure MySQL server is running
2. Update database credentials in:

   ```
   dao/ItemDAOImpl.java
   ```
3. Compile the project:

   ```bash
   javac -d . -cp src/mysql-connector-j-9.x.x.jar src/*/*.java
   ```
4. Run the application:

   ```bash
   java -cp ".;src/mysql-connector-j-9.x.x.jar" ui.ItemUI
   ```
   
---

## Future Improvements

* Search items by name or status
* Add date/location tracking
* Improve UI using layout managers
* Add user authentication
* Item claim verification system

---

## What I Learned

* Designing modular applications using layered architecture
* Integrating Java Swing with MySQL via JDBC
* Managing structured item data using SQL
* Building user-friendly desktop interfaces

---

## Author

Shravani T.
