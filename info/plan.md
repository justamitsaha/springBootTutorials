# 🗺️ Spring Boot Mastery Project Plan

This roadmap breaks down Spring Boot into 8 sequentially ordered hands-on projects, spanning 🟢 **Junior-Mid**, 🟡 **Mid-Senior**, and 🔴 **Senior-Lead** competency levels.

---

## 📚 Study Sequence & Module Map

### 1. `01_spring-basic`
- **Focus:** Core Framework & IoC Container.
- **Topics:** Tight vs. Loose Coupling, IoC Container, Dependency Injection Types (Constructor/Setter/Field), Bean Lifecycle (`@PostConstruct`, `@PreDestroy`), Bean Scopes (Singleton, Prototype), Component Scanning, and Java-based `@Configuration`.

### 2. `02_spring-web-basic`
- **Focus:** Spring Boot Foundations, RESTful APIs & Configuration.
- **Topics:** Starters, Auto-configuration, `@RestController`, Request Mapping, Profiles (`application-dev.yml`), Externalized Configuration (`@Value`, `@ConfigurationProperties`), JSR-380 Request Validation (`@Valid`), and Global Error Handling (`@RestControllerAdvice`).

### 3. `03_spring-data-jpa`
- **Focus:** Data Persistence, Performance & Transactions.
- **Topics:** Entity Mapping, Relationships (One-to-One, One-to-Many), Spring Data Repositories, JPQL vs. Native Queries, **N+1 Problem** resolution (`JOIN FETCH`), Interface Projections, and H2 Console integration.

### 4. `04_spring-security-pro`
- **Focus:** Enterprise Identity, Authentication & Authorization.
- **Topics:**
  - **Core Security:** Security Filter Chain (`SecurityFilterChain`), BCrypt Password Encoding, Database-backed authentication (`UserDetailsService`).
  - **Stateless Identity:** JWT token generation and validation (`JwtAuthenticationFilter`), Role-Based Access Control (RBAC), and Method-Level Security (`@PreAuthorize`).

### 5. `05_spring-aop-internals`
- **Focus:** Framework Internals, Proxies & Cross-Cutting Concerns.
- **Topics:**
  - **AOP:** Aspects, Pointcuts, `@Around` advice, custom marker annotations (`@LogExecutionTime`).
  - **Internals:** `BeanPostProcessor` lifecycle hooks, Handler Interceptors (`HandlerInterceptor`), Asynchronous execution (`@Async`), and dynamic proxy mechanics.

### 6. `06_spring-testing-mastery`
- **Focus:** Engineering Excellence, Testing Strategy & Quality Assurance.
- **Topics:**
  - **Slice Testing:** Isolated layer testing with `@WebMvcTest` + `MockMvc` and `@DataJpaTest`.
  - **Integration Testing:** Real infrastructure integration using **Testcontainers** (Dockerized PostgreSQL) and Spring Boot 3.1+ `@ServiceConnection`.
  - **Architecture Enforcement:** Automated package and dependency rules using **ArchUnit**.

### 7. `07_spring-observability-resilience`
- **Focus:** Production-Grade Operations, Fault Tolerance & Metrics.
- **Topics:**
  - **Observability:** Spring Boot Actuator (`/health`, `/metrics`), custom `HealthIndicator`, structured logging.
  - **Fault Tolerance:** **Resilience4j** declarative patterns including Circuit Breaker and Retry with fallbacks.
  - **Tracing:** Distributed tracing foundation with Micrometer and Zipkin/Brave.

### 8. `08_spring-reactive-concurrency`
- **Focus:** Modern High-Performance Architectures & Non-Blocking I/O.
- **Topics:**
  - **Virtual Threads (Project Loom):** High-throughput lightweight concurrency in Java 21+ and Spring Boot 3.2+ (`spring.threads.virtual.enabled=true`).
  - **Spring WebFlux:** Asynchronous, non-blocking reactive streams using Project Reactor (`Mono`, `Flux`).
  - **Caching:** Reactive caching abstractions with Redis.

---

## 📈 Learning Path Summary

| Level | Modules | Primary Goal |
| :--- | :--- | :--- |
| **Junior-Mid** | `01_spring-basic`, `02_spring-web-basic`, `03_spring-data-jpa` | Master core IoC/DI and build production-ready data-driven REST APIs. |
| **Mid-Senior** | `04_spring-security-pro`, `05_spring-aop-internals`, `06_spring-testing-mastery` | Secure, optimize, understand framework internals, and test with enterprise standards. |
| **Senior-Lead** | `07_spring-observability-resilience`, `08_spring-reactive-concurrency` | Architect for resilience, high concurrency (Virtual Threads/WebFlux), and cloud observability. |

---

> [!TIP]
> For upcoming enterprise additions (Kafka, Flyway, Swagger, Docker Compose), check out the **[Architectural Gaps & Enhancement Roadmap](./enhancements.md)**.
