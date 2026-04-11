# 🔴 spring-Data-JPA: Advanced Persistence

This project demonstrates advanced Spring Data JPA features including relationship management and performance optimization using an enterprise-standard structure.

## 🏁 Architectural Structure

| Package | Purpose | Key Classes |
| :--- | :--- | :--- |
| `controller` | Persistence API Entry points | `ProductController`, `CustomerController`, `PerformanceController` |
| `entity` | Database Mappings | `Product`, `Customer`, `Order` |
| `repository` | Data Access Abstractions | `ProductRepository`, `CustomerRepository` |
| `projection` | Optimized Read Views | `CustomerSummary` (Interface Projection) |

## 🚀 How to Run & Test

### 1. Start the Application
```bash
mvn spring-boot:run
```

### 2. Inspect Database
- **URL**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **JDBC**: `jdbc:h2:mem:testdb`

### 3. Performance Testing (N+1 Problem)
- **N+1 Case**: `GET http://localhost:8080/api/v1/performance/n-plus-one` (Multiple queries in logs)
- **JOIN FETCH Case**: `GET http://localhost:8080/api/v1/performance/join-fetch` (Single optimized query)
- **Projection Case**: `GET http://localhost:8080/api/v1/performance/projections` (Selective column fetch)
