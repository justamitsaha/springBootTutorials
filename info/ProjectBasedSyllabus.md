# 🚀 Senior Spring Boot Learning Roadmap (Project-Based)

This syllabus bridges the gap between a "developer who uses Spring" and a "Tech Lead who understands Spring." Each module is designed to be implemented as a standalone project.

---

## 🏗️ Module 1: Core Mechanics & "The Why"
*Goal: Understand the magic under the hood.*

- **Project: `spring-internal-mechanics`**
    - **Why Spring?** Implement a "Mini-Spring" using Reflection API to understand how `@Component` scanning works.
    - **Bean Post Processors:** Use `BeanPostProcessor` to intercept bean creation (e.g., custom logging for every bean initialized).
    - **Conditional Configuration:** Create beans that only initialize if a specific system property or file exists (`@ConditionalOnProperty`, `@ConditionalOnResource`).
    - **Custom Starters:** Build a "Library" project and a "Client" project. Learn how `spring.factories` (or `org.springframework.boot.autoconfigure.AutoConfiguration.imports`) enables auto-configuration.

---

## 🛠️ Module 2: Advanced Web & Cross-Cutting Concerns
*Goal: Implement patterns that keep the codebase clean as it scales.*

- **Project: `spring-web-advanced`**
    - **AOP (Aspect Oriented Programming):** Create a `@LogExecutionTime` annotation using `AspectJ` to profile method performance without cluttering business logic.
    - **Filters vs. Interceptors:** Implement a `OncePerRequestFilter` for correlation IDs (Tracing) and an `HandlerInterceptor` for execution timing.
    - **Global Error Handling:** Deep dive into `@ControllerAdvice` and `ProblemDetail` (RFC 7807) for standardized API errors.
    - **Content Negotiation:** Support both JSON and XML/CSV outputs for the same endpoint.

---

## 🔐 Module 3: Enterprise Security & Identity
*Goal: Move beyond basic auth to production-ready identity management.*

- **Project: `spring-security-pro`**
    - **Architecture:** Debug the `FilterChainProxy` to see exactly how a request moves through the 15+ default filters.
    - **JWT from Scratch:** Implement a stateless authentication flow with Access and Refresh tokens.
    - **Method-Level Security:** Use SpEL (Spring Expression Language) in `@PreAuthorize` to check if a user "owns" a resource before allowing an update.
    - **OAuth2 / OpenID Connect:** Integrate with a provider like Google or GitHub using `spring-boot-starter-oauth2-client`.

---

## 📈 Module 4: Observability & Production Readiness
*Goal: Learn how to manage a "live" application.*

- **Project: `spring-observability`**
    - **Actuator Customization:** Create a custom `/health` indicator and a custom `/info` contributor.
    - **Micrometer Metrics:** Export custom business metrics (e.g., `orders_placed_total`) to a Prometheus/Grafana stack (running in Docker).
    - **Structured Logging:** Configure Logback to output JSON for ELK/Splunk integration.
    - **Graceful Shutdown:** Implement and test how Spring handles SIGTERM signals during long-running tasks.

---

## 💾 Module 5: Advanced Data & Transactions
*Goal: Handle data consistency and performance at a lead level.*

- **Project: `spring-data-mastery`**
    - **Transactional Pitfalls:** Demonstrate cases where `@Transactional` fails (e.g., self-invocation, checked exceptions).
    - **Database Migrations:** Integrate **Flyway** or **Liquibase** to manage schema versioning.
    - **Caching Abstraction:** Implement multi-level caching (Caffeine for L1, Redis for L2).
    - **Optimistic Locking:** Use `@Version` to handle concurrent updates and prevent "Lost Update" scenarios.

---

## 🧪 Module 6: Testing Strategy & Quality
*Goal: Move beyond simple unit tests to reliable integration suites.*

- **Project: `spring-testing-mastery`**
    - **Testcontainers:** Run integration tests against a real PostgreSQL/MySQL container instead of H2.
    - **Slicing Tests:** Use `@WebMvcTest`, `@DataJpaTest`, and `@JsonTest` to run fast, isolated tests.
    - **Mocking Strategy:** Proper use of `@MockBean` vs `@SpyBean`.
    - **ArchUnit:** Write a test that fails if a Controller calls a Repository directly (enforcing Layered Architecture).

---

## ⚡ Module 7: Modern Concurrency & Reactive
*Goal: Future-proof your skills with Java 21+ features.*

- **Project: `spring-high-performance`**
    - **Virtual Threads (Project Loom):** Enable virtual threads in Spring Boot 3.2+ and compare thread-dump size with traditional platform threads.
    - **WebFlux Basics:** Build a simple non-blocking API to understand `Mono` and `Flux`.
    - **RSocket:** Implement a "Fire-and-Forget" or "Stream" communication pattern.

---

## 🧩 Senior Rapid-Fire Checklist (Knowledge Areas)
1. **Circular Dependencies:** Why did Spring Boot 2.6+ disable them by default?
2. **Proxying:** What is the difference between JDK Dynamic Proxies and CGLIB?
3. **ApplicationContext:** What is the difference between `BeanFactory` and `ApplicationContext`?
4. **Bean Scopes:** How do you inject a `Prototype` bean into a `Singleton` bean? (Look up `@Lookup` or `ObjectProvider`).
5. **AOT & GraalVM:** Why does `Spring Native` require Ahead-Of-Time compilation?
