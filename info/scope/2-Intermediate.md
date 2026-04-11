# 🟡 Spring Boot: Intermediate

Move beyond basic setup to handle real-world application requirements like validation, advanced data mapping, and production monitoring.

## 1. Advanced Configuration
- **Profiles:** Environment-specific configuration (e.g., `application-dev.yml`, `application-prod.yml`).
- **@ConfigurationProperties:** Type-safe mapping of structured properties to Java objects.
- **Environment API:** Accessing system and environment variables.

## 2. API Robustness
- **Request Validation:** Using JSR-380 (`jakarta.validation`) for API bodies (`@Valid`).
- **Global Exception Handling:** Using `@ControllerAdvice` and `@ExceptionHandler`.
- **Response Mapping:** Using `ResponseEntity` to control HTTP status codes.
- **Swagger / OpenAPI:** Documenting APIs automatically.

## 3. Deep Dive into Spring Data JPA
- **Advanced Querying:** JPQL vs. Native SQL queries.
- **Performance Optimization:** 
    - Solving the **N+1 problem** (`JOIN FETCH`).
    - Using **Projections** (Interface vs. Class-based).
    - Understanding **FetchTypes** (EAGER vs. LAZY).
- **Relationships:** One-to-One, One-to-Many, Many-to-Many.
- **Database Migrations:** Using **Flyway** or **Liquibase**.

## 4. Security Basics
- **Spring Security Fundamentals:** Authentication vs. Authorization.
- **Filter Chain:** Understanding how requests are intercepted.
- **Form-based Auth:** Basic login/logout configuration.
- **In-Memory vs. Database Authentication:** Managing users.

## 5. Operations & Monitoring
- **Spring Boot Actuator:** Monitoring `/health`, `/info`, and custom metrics.
- **Logging Strategy:** Configuring SLF4J and Logback for different environments.
- **DevTools:** Fast development cycles and live-reloads.

## 6. Testing Fundamentals
- **JUnit 5 & Mockito:** Unit testing business services.
- **Spring Boot Test:** Integration testing using `@SpringBootTest`.
- **Slicing Tests:** Using `@WebMvcTest` and `@DataJpaTest`.

## 7. Cross-Cutting Concerns
- **Spring AOP (Aspect Oriented Programming):** Basic logging or performance tracking using `@Aspect`.
- **Async Processing:** Using `@Async` for background tasks.
