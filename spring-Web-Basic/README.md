# 🟡 spring-Web-Basic: Intermediate Spring Boot

This project demonstrates the core features of a production-ready Spring Boot web application using standard enterprise architecture patterns.

## 🏁 Architectural Structure

| Package | Purpose | Key Classes |
| :--- | :--- | :--- |
| `controller` | API Entry points | `HelloController`, `RegistrationController`, `ConfigController` |
| `dto` | Data Transfer Objects | `UserDto`, `UserRegistrationDto` |
| `config` | Type-safe Configuration | `AppSettings` (@ConfigurationProperties) |
| `exception` | Global Error Handling | `GlobalExceptionHandler` (@RestControllerAdvice) |

## 🚀 How to Run & Test

### 1. Start the Application
Run the standard Spring Boot entry point:
```bash
mvn spring-boot:run
```

### 2. Test Endpoints
- **GET Hello**: `http://localhost:8080/api/v1/hello`
- **GET User**: `http://localhost:8080/api/v1/users/Amit`
- **POST Register (Validation)**: `POST http://localhost:8080/api/v2/users`
  - Body: `{"name":"A", "email":"bad-email"}`
- **GET Config**: `http://localhost:8080/api/config`
