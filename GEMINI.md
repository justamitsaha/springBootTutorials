# Antigravity Workspace Guidelines: Spring Boot Tutorials

This workspace contains a progressive, 8-module hands-on curriculum for mastering Spring Boot from core framework fundamentals to senior cloud-native architecture.

## 📁 Repository Structure

The modules are ordered sequentially from 01 to 08:
- `01_spring-basic`: Core Spring framework mechanics (IoC, DI, Bean Lifecycle, Scopes, Component Scanning, Java Config).
- `02_spring-web-basic`: Spring Boot foundations, RESTful endpoints, `@RestControllerAdvice`, JSR-380 validation, YAML profiles, type-safe configuration.
- `03_spring-data-jpa`: Spring Data JPA, Entity mappings, relationships, N+1 optimization (`JOIN FETCH`), interface projections, H2 console.
- `04_spring-security-pro`: Security Filter Chain, BCrypt password hashing, database user authentication, stateless JWT authentication, RBAC (`@PreAuthorize`).
- `05_spring-aop-internals`: Aspect-Oriented Programming (AOP), custom annotations (`@LogExecutionTime`), `BeanPostProcessor` hooks, `HandlerInterceptor`, `@Async` processing.
- `06_spring-testing-mastery`: Slice testing (`@WebMvcTest`, `@DataJpaTest`), Testcontainers (PostgreSQL), ArchUnit architectural enforcement.
- `07_spring-observability-resilience`: Spring Boot Actuator, custom `HealthIndicator`, Resilience4j (Circuit Breakers, Retries, Fallbacks), Micrometer tracing.
- `08_spring-reactive-concurrency`: Virtual Threads (Java 21 Project Loom), Spring WebFlux (`Mono`, `Flux`), non-blocking reactive Redis caching.
- `info/`: Extended syllabi, learning plans, and interview question banks.

## 🛠️ Tech Stack & Conventions

- **Java Version:** Java 17 for modules 01, 03-07; Java 21 for modules 02 and 08 (Virtual Threads).
- **Spring Boot Version:** 3.2.x
- **Build System:** Apache Maven (independent `pom.xml` per module).
- **Module Structure:** Each module contains:
  - `src/main/java`: Application source code
  - `src/main/resources`: `application.properties` or `application.yml`
  - `src/test/java`: Automated test suites
  - `pom.xml`: Maven configuration
  - `README.md`: Architecture overview and execution guide
  - `scope.md`: Learning objectives and topic breakdown
  - `Q&A.md`: Interview and concept questions for that module

## 🚀 Common Commands

```bash
# Compile and build an individual module
cd <module_folder>
mvn clean compile

# Run unit and integration tests
mvn test

# Run a Spring Boot application
mvn spring-boot:run

# Run a specific concept runner in 01_spring-basic
mvn spring-boot:run -Dspring-boot.run.main-class=com.saha.amit.spring_Basic.B_dependencyInjection.DIRunner
```
