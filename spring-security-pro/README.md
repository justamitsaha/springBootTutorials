# 🔴 spring-security-pro: Advanced Identity Management

This project demonstrates how to implement a secure, stateless identity layer using Spring Security, JWT, and Role-Based Access Control (RBAC).

## 🏁 Architectural Structure

| Package | Purpose | Key Classes |
| :--- | :--- | :--- |
| `config` | Security Configuration | `SecurityConfig` (Filter Chain) |
| `security` | JWT Logic & Filters | `JwtUtils`, `JwtAuthenticationFilter` |
| `service` | User Identity Logic | `CustomUserDetailsService` |
| `controller` | Auth & Protected APIs | `AuthController`, `TestController` |
| `entity` | DB Identity Model | `User` (Username, Password, Roles) |

## 🚀 How to Run & Test

### 1. Start the Application
```bash
mvn spring-boot:run
```

### 2. Register a User
- **URL**: `POST http://localhost:8080/api/auth/register`
- **Body**:
  ```json
  {
    "username": "amit",
    "password": "password123",
    "roles": ["ROLE_ADMIN"]
  }
  ```

### 3. Login & Get JWT
- **URL**: `POST http://localhost:8080/api/auth/login`
- **Body**: `{"username": "amit", "password": "password123"}`
- **Action**: Copy the `token` from the JSON response.

### 4. Access Protected Endpoints
Use the token in the `Authorization` header as a `Bearer` token:
- **Admin Access**: `GET http://localhost:8080/api/test/admin`
- **User Access**: `GET http://localhost:8080/api/test/user`
- **Header**: `Authorization: Bearer <your_token_here>`

---

## 📂 Project Highlights
- **Statelessness**: No JSESSIONID is used; the server is completely stateless.
- **BCrypt**: Passwords are never stored in plain text.
- **RBAC**: Access is strictly controlled via `@PreAuthorize`.
