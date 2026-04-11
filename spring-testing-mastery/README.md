# 🔴 spring-testing-mastery: Testing Excellence

This project demonstrates how to build a world-class testing suite for Spring Boot applications, covering everything from fast slice tests to real infrastructure integration.

## 🏁 Architectural Structure

| Package | Purpose | Key Classes |
| :--- | :--- | :--- |
| `controller` | API Layer | `EmployeeController` |
| `entity` | Data Model | `Employee` |
| `repository` | Data Access | `EmployeeRepository` |

## 🧪 Testing Strategy

### 1. Slice Testing (Fast & Isolated)
- **Repository**: `EmployeeRepositoryTest.java` (uses `@DataJpaTest`).
- **Controller**: `EmployeeControllerTest.java` (uses `@WebMvcTest` + `MockMvc`).

### 2. Real Infrastructure (Testcontainers)
- **Integration**: `EmployeeIntegrationTest.java` (uses `@SpringBootTest` + Dockerized **PostgreSQL**).
- **Benefit**: Ensures your code works against the actual production database engine.

### 3. Architecture Enforcement (ArchUnit)
- **Rules**: `ArchitectureTest.java`.
- **Purpose**: Programmatically prevents architectural drift (e.g., "Controllers must not access Repositories directly").

## 🚀 How to Run Tests
1. **Requirement**: Ensure **Docker** is running on your machine (for Testcontainers).
2. Run all tests via Maven:
   ```bash
   mvn test
   ```

---

## 📂 Project Highlights
- **ServiceConnection**: Demonstrates Spring Boot 3.1+'s automatic container configuration.
- **MockMvc**: High-performance controller testing without a full server.
- **Fluent Assertions**: Uses **AssertJ** for readable, robust test cases.
