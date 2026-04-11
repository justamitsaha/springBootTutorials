# 🟡 Spring Boot: Web Basics (Intermediate)

This module focuses on building production-ready REST APIs, handling user input safely, and managing environment-specific configurations.

## 🏁 Topics & Descriptions

### 1. REST API Development
- **@RestController**: A specialized version of `@Controller` that automatically adds `@ResponseBody` to every method, ensuring data is returned as JSON/XML.
- **Request Mappings**: Using `@GetMapping`, `@PostMapping`, etc., to map HTTP verbs to Java methods.
- **Path Variables**: Using `{name}` in URLs to identify specific resources (e.g., `/users/1`).
- **Request Parameters**: Using `?query=abc` for optional filtering or searching logic.

### 2. DTO Pattern (Data Transfer Objects)
- **Purpose**: Decoupling the API contract from the internal Database Entity.
- **Benefit**: Prevents sensitive data (like passwords or internal IDs) from being exposed accidentally.
- **Implementation**: Using Java **Records** for immutable, lightweight data containers.

### 3. Request Validation
- **Jakarta Validation (JSR-380)**: Using annotations like `@NotEmpty`, `@Email`, and `@Size` to enforce business rules on incoming data.
- **@Valid**: Triggering the validation engine at the Controller level.

### 4. Global Exception Handling
- **@RestControllerAdvice**: A centralized interceptor for handling exceptions thrown across all Controllers.
- **Error Consistency**: Ensuring the client always receives a predictable error format (e.g., Status Code + Message + Timestamp).

### 5. Externalized Configuration
- **Spring Profiles**: Defining different behaviors for `dev`, `test`, and `prod` environments.
- **@ConfigurationProperties**: Mapping groups of related properties from `.yml` files into type-safe Java objects.
- **YAML vs Properties**: Using hierarchical `.yml` for better readability of complex configurations.
