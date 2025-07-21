# Bookstore

A simple Spring Boot + HSQLDB application that simulates a bookstore management system.  
You can browse books, add new books, update existing records, and track sales—all against an in-memory HyperSQL database.

This reference project demonstrates a clean Controller → Service → Repository layering, externalized SQL scripts (`schema.sql`, `data.sql`), and IntelliJ-friendly setup.  


---

## Table of Contents

1. [Description](#description)
2. [Prerequisites](#prerequisites)
3. [Getting Started](#getting-started)
    - [Clone the repository](#clone-the-repository)
    - [Build & Run (IntelliJ IDEA)](#build--run-intellij-idea)
4. [Swagger UI](#swagger-ui)
5. [Configuration](#configuration)
6. [Database Initialization](#database-initialization)
7. [Database Structure](#database-structure)
8. [Available Endpoints](#available-endpoints)
9. [Project Structure](#project-structure)

---

## Description

This example implements basic CRUD operations for a **Bookstore**:

- **MVP**
    - Find a book by ID
    - List all books
    - Add a book
    - Update a book
    - Delete a book

You’ll see how layers connect, how to externalize SQL scripts (`schema.sql`, `data.sql`), and how to work with an in-memory HSQLDB.

---

## Prerequisites

- Java 21
- Gradle (or use the included `gradlew`)
- IntelliJ IDEA (optional, but recommended)

---

## Getting Started

---

### Clone the repository

Via IntelliJ IDEA

1. Open IntelliJ IDEA.
2. From the Welcome screen (or File menu), choose **Get from Version Control…**
3. In the dialog that appears, paste `https://github.com/marti-truu/bookstore.git` into the **URL** field.
4. Select your desired local directory and click **Clone**.
5. Once the clone completes, IntelliJ will open the project—allow it to import/reload the Gradle settings.

Via command line
```bash
git clone https://github.com/marti-truu/bookstore.git
```

---

### Build & Run (IntelliJ IDEA)

1. **Open the project**
    - In IntelliJ IDEA, select **File ▸ Open…** and choose the project’s root folder (containing `build.gradle`).
    - IntelliJ will automatically reload the Gradle project. If you encounter any issues, click the “Refresh” icon in the Gradle tool window to force a manual reload.

2. **Run the application**
    - In the **Project** tool window, navigate to `src/main/java/eu/graduationproject/bookstore/BookstoreApplication.java`.
    - Click the green ▶︎ icon next to the `main` method, or right-click the file and choose **Run 'BookstoreApplication'**.

3. **Verify startup**
    - The console should show Spring Boot starting on port 8080.
    - Open your browser to Swagger UI page `http://localhost:8080/swagger-ui/index.html` to confirm the server is running.

4. **Stop the server**
    - Click the red ■ icon in the Run tool window, or press **Ctrl + F2** (Windows/Linux) or **⌘ + F2** (macOS).

---

## Swagger UI

After startup, you can browse your OpenAPI docs at: `http://localhost:8080/swagger-ui/index.html`

---
## Configuration

All runtime settings live in `src/main/resources/application.properties`.

---

## Database Initialization

On startup, Spring Boot will automatically run any `schema.sql` and `data.sql` files found on the classpath (i.e. in `src/main/resources`) to build and seed your HSQLDB schema.

### schema.sql

- Defines your tables, constraints, indexes, etc.

### data.sql

- Populates your newly created tables with initial or sample data.
- Executed immediately after `schema.sql`, so all referenced tables already exist.
- Use it to insert lookup values, demo rows, or any seed data your application needs on startup.

---

## Available Endpoints

| Method | Path               | Description                              |
| ------ | ------------------ | ---------------------------------------- |
| GET    | `/book/{bookId}`   | Retrieve a single book by its ID         |
| GET    | `/books`           | List all books in the store              |
| POST   | `/book`            | Create a new book record                 |
| PUT    | `/book/{bookId}`   | Update an existing book's details        |
| DELETE | `/book/{bookId}`   | Delete a book by its ID                  |

---

## Project Structure

```plaintext
bookstore-project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── eu.graduationproject.bookstore/
│   │   │       ├── controller/        # REST controllers & DTOs
│   │   │       ├── persistence/       # JPA entities, repositories, mappers
│   │   │       ├── service/           # Business-logic services
│   │   │       └── BookstoreApplication.java
│   │   └── resources/
│   │       ├── application.properties # Spring configuration
│   │       ├── schema.sql             # DDL for HSQLDB schema
│   │       └── data.sql               # Initial seed data
│   └── test/
│       └── java/
│           └── eu.graduationproject.bookstore/
│               └── BookstoreApplicationTests.java
├── build.gradle                       # Gradle build script
├── settings.gradle                    # Gradle settings
├── gradlew / gradlew.bat              # Gradle wrapper
├── .gitignore                         # Files to ignore in Git
├── .gitattributes                     # Git attributes
└── HELP.md                            # Project help & notes
```

---
