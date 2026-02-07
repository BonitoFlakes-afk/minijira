# MiniJira API

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue.svg)](https://www.postgresql.org/)
[![Build](https://img.shields.io/badge/Build-Maven-critical)](https://maven.apache.org/)

> A robust, enterprise-grade RESTful API for agile project management and issue tracking.

---

## 📖 Table of Contents
- [About the Project](#-about-the-project)
- [Tech Stack](#-tech-stack)
- [Architecture](#-architecture)
- [Getting Started](#-getting-started)
- [API Documentation](#-api-documentation)
- [Roadmap](#-roadmap)
- [Contact](#-contact)

---

## About the Project
**MiniJira** is a backend system designed to replicate core functionalities of enterprise issue tracking software. It provides a scalable REST API to manage project lifecycles, user assignments, and ticket workflows.

The project demonstrates a clean **Layered Architecture** (Controller, Service, Repository) and adheres to strict **RESTful principles**. It is optimized for data integrity using **PostgreSQL** and secure configuration management.

### Key Capabilities
* **Project Lifecycle Management:** Create, update, and soft-delete projects.
* **Granular Issue Tracking:** Manage tickets with priorities, status, and assignees.
* **Relational Integrity:** Complex mappings (One-to-Many, Many-to-One) handled via JPA.
* **Secure Configuration:** Externalized credentials using Environment Variables.

---

## Tech Stack
| Component | Technology | Description |
| :--- | :--- | :--- |
| **Backend** | Java 17 + Spring Boot | Core application framework |
| **Database** | PostgreSQL | Relational persistence layer |
| **ORM** | Spring Data JPA / Hibernate | Object-Relational Mapping |
| **Build Tool** | Maven | Dependency management |
| **Testing** | JUnit 5 | Unit and integration testing |

---

## Getting Started

### Prerequisites
Ensure you have the following installed on your local machine:
* **Java Development Kit (JDK) 17** or higher
* **PostgreSQL** (running on port 5432)
* **Git**
* **Maven** (optional, wrapper included)

### Installation

1.  **Clone the Repository**
    ```bash
    git clone [https://github.com/BonitoFlakes-afk/minijira.git](https://github.com/BonitoFlakes-afk/minijira.git)
    cd minijira
    ```

2.  **Configure the Database**
    Create a local PostgreSQL database named `minijira`.
    ```sql
    CREATE DATABASE minijira;
    ```

3.  **Set Environment Variables**
    *Security Best Practice: Never hardcode passwords.*
    
    **Windows (PowerShell):**
    ```powershell
    setx DB_PASSWORD "your_actual_password"
    # Restart your terminal/IDE after running this
    ```
    
    **macOS / Linux:**
    ```bash
    export DB_PASSWORD="your_actual_password"
    ```

4.  **Build and Run**
    ```bash
    ./mvnw spring-boot:run
    ```
    The API will start at: `http://localhost:8080`

---

## 🔌 API Documentation

| HTTP Method | Endpoint | Description | Payload Example |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/projects` | Retrieve all projects | N/A |
| **POST** | `/api/projects` | Create a new project | `{"name": "Alpha", "description": "..."}` |
| **GET** | `/api/tickets/{id}` | Get ticket details | N/A |
| **POST** | `/api/tickets` | Create a ticket | `{"title": "Bug fix", "priority": "HIGH"}` |

> *Full Swagger/OpenAPI documentation coming soon.*

---

## 🔮 Roadmap
- [x] Core CRUD Operations
- [x] PostgreSQL Integration
- [ ] User Authentication (JWT Security)
- [ ] Docker Support
- [ ] Pagination and Sorting for Tickets

---

## Author

**Karunya C**
* **GitHub:** [@BonitoFlakes-afk](https://github.com/BonitoFlakes-afk)

---
