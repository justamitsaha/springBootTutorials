# 🎤 Testing Mastery: Interview Q&A

Critical questions and answers covering Slicing, Testcontainers, and Architecture testing.

---

### 🔹 1. Slice Testing vs @SpringBootTest
**Q:** Why is `@WebMvcTest` better than `@SpringBootTest` for controller tests?

**Answer:**
- **Speed:** `@SpringBootTest` starts the entire application, including DB connections and every bean in the context. This is slow.
- **Isolation:** `@WebMvcTest` only starts the web-related beans (Controllers, Filters, Advice). You mock everything else. This allows you to focus strictly on testing request mappings, validation, and JSON serialization.

---

### 🔹 2. Testcontainers
**Q:** What are the benefits of using Testcontainers over an in-memory database like H2?

**Answer:**
- **Consistency:** H2 is great, but it doesn't support every Postgres/MySQL feature (e.g., specific JSON operators, stored procedures).
- **Reliability:** Your tests run against the **exact same engine** used in production. This catches environment-specific bugs early in the pipeline.
- **Isolation:** Testcontainers manages the lifecycle (startup/shutdown) automatically, ensuring a fresh DB instance for every test run.

---

### 🔹 3. Mocking Strategy
**Q:** What is the difference between `@MockBean` and `@SpyBean`?

**Answer:**
- **@MockBean:** Creates a complete mock of the bean and replaces the real one in the ApplicationContext. All methods return default values (null/0) unless stubbed.
- **@SpyBean:** Wraps the **real** bean in the context. You can call the real methods but still "spy" on them to verify calls or stub only specific methods.

---

### 🔹 4. Architecture Enforcement
**Q:** What is ArchUnit and how does it help a Tech Lead?

**Answer:**
- ArchUnit is a library for checking the architecture of your Java code.
- **Lead Benefit:** It allows you to automate code reviews for architectural rules. Instead of manually checking if a junior dev put DB logic in a controller, the build will simply fail if the rule is violated.

---

### 🔹 5. @ServiceConnection
**Q:** How does the `@ServiceConnection` annotation in Spring Boot 3.1+ simplify testing?

**Answer:**
- Previously, you had to manually set `spring.datasource.url` using `@DynamicPropertySource` by getting the port from the Docker container.
- **Now:** You just annotate the static container field with `@ServiceConnection`, and Spring Boot automatically detects the container type and configures the connection properties for you.

---

### 🔹 6. Contract Testing
**Q:** What is Consumer-Driven Contract (CDC) testing?

**Answer:**
- CDC ensures that a service (Provider) meets the expectations of its clients (Consumers).
- Instead of the Provider saying "here is my API," the Consumer says "here is what I need."
- Tools like **Spring Cloud Contract** or Pact help ensure that changes in the Provider don't break the Consumer's expected contract.
