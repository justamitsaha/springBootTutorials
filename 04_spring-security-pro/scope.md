# 🔴 Spring Boot: Security Pro (Advanced)

This module focuses on implementing an enterprise-grade security layer using Spring Security, JWT, and Role-Based Access Control (RBAC).

## 🏁 Topics & Descriptions

### 1. The Security Filter Chain
- **Concept**: A chain of filters that intercept every request. Spring Security is essentially a series of Servlet Filters.
- **Statelessness**: Configured using `SessionCreationPolicy.STATELESS` to ensure the server doesn't store session data, making it ideal for microservices.

### 2. JWT (JSON Web Tokens)
- **JwtUtils**: Logic for signing (generating) and parsing (validating) tokens using a secret key.
- **JwtAuthenticationFilter**: A custom filter that extracts the token from the `Authorization: Bearer` header and sets the user context if valid.

### 3. Database-Backed Authentication
- **UserDetailsService**: A core interface used to retrieve user-specific data from the database.
- **PasswordEncoder**: Using `BCrypt` to hash passwords before storing them, ensuring security even if the DB is compromised.

### 4. Authorization & RBAC
- **@EnableMethodSecurity**: Enables the use of annotations like `@PreAuthorize` to secure individual methods.
- **RBAC (Role-Based Access Control)**: Restricting access to endpoints based on the user's assigned roles (e.g., `ROLE_USER`, `ROLE_ADMIN`).

### 5. Social Login (OAuth2)
- **Concept**: Allowing users to log in via third-party providers like Google or GitHub using standard OAuth2 protocols.
- **Starter**: Managed via `spring-boot-starter-oauth2-client`.
