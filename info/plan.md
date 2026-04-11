# 🗺️ Spring Boot Mastery Project Plan

This plan breaks down the 🟢 **Basics**, 🟡 **Intermediate**, and 🔴 **Advanced** topics into 8 logical projects.

---

## ✅ Completed Projects (3)

### 1. `spring-Basic`
- **Focus:** Core Framework & IoC.
- **Topics:** Tight vs Loose Coupling, IoC Container, DI Types (Constructor/Setter), Bean Lifecycle, Scopes, and Component Scanning.

### 2. `springBootBasic`
- **Focus:** Spring Boot Foundations & Web.
- **Topics:** Starters, Auto-configuration, `@RestController`, Request Mapping, Profiles (`application-dev.yml`), Externalized Config (`@Value`, `@ConfigurationProperties`), and Basic Validation.

### 3. `springBootJPA`
- **Focus:** Data Access & Performance.
- **Topics:** Entity Mapping, Relationships (1:1, 1:N), JPQL vs Native Queries, **N+1 Problem** resolution (`JOIN FETCH`), Projections, and H2 Console.

---

## 🚀 Upcoming Projects (5)

### 4. `spring-security-pro`
- **Focus:** Authentication, Authorization, and Identity.
- **Topics:**
    - **Intermediate:** Filter Chain, Database-backed Auth, Form Login.
    - **Advanced:** JWT (Stateless Auth), OAuth2/OIDC (Social Login), Method-level security (`@PreAuthorize`), and RBAC (Role-Based Access Control).

### 5. `spring-aop-internals`
- **Focus:** The "Magic" of Spring & Cross-Cutting Concerns.
- **Topics:**
    - **Intermediate:** AOP (Aspects, Pointcuts), `@Async` processing, Global Exception Handling (`@ControllerAdvice`).
    - **Advanced:** `BeanPostProcessors`, Custom Starters, JDK Dynamic Proxies vs CGLIB, and the `ApplicationContext` startup flow.

### 6. `spring-observability-resilience`
- **Focus:** Production-Grade Operations.
- **Topics:**
    - **Intermediate:** Actuator Customization, Structured Logging (JSON), Health Indicators.
    - **Advanced:** Distributed Tracing (Micrometer/Zipkin), Resilience4j (Circuit Breaker, Rate Limiter), and Prometheus/Grafana integration.

### 7. `spring-reactive-concurrency`
- **Focus:** Modern High-Performance Architectures.
- **Topics:**
    - **Advanced:** Project Loom (Virtual Threads), WebFlux (Reactive Streams), Multi-level Caching (Caffeine/Redis), and Distributed Consistency.

### 8. `spring-testing-mastery`
- **Focus:** Engineering Excellence & Reliability.
- **Topics:**
    - **Intermediate:** Slice Testing (`@WebMvcTest`, `@DataJpaTest`), JUnit 5/Mockito.
    - **Advanced:** **Testcontainers** (Docker-based integration tests), **ArchUnit** (Architecture enforcement), and Contract Testing.

---

## 📈 Learning Path Summary
| Level | Projects | Primary Goal |
| :--- | :--- | :--- |
| **Junior-Mid** | 1, 2, 3 | Build functional, data-driven REST APIs. |
| **Mid-Senior** | 4, 5, 8 | Secure, optimize, and test for enterprise standards. |
| **Senior-Lead** | 6, 7 | Architect for high-scale, cloud-native observability. |
