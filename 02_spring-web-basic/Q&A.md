# 🎤 Spring Web: Interview Q&A

Critical questions and answers covering REST, Validation, and Configuration in Spring Boot.

---

### 🔹 1. @Controller vs @RestController
**Q:** What is the difference between `@Controller` and `@RestController`?

**Answer:**
- **@Controller:** Used for traditional web apps where the return value is typically a **view name** (HTML page). You must add `@ResponseBody` manually to return data.
- **@RestController:** A specialized controller for REST APIs. It combines `@Controller` and `@ResponseBody`. Every method automatically writes its return value directly to the HTTP response body as JSON/XML.

---

### 🔹 2. Handling Path Variables vs Request Parameters
**Q:** When would you use `@PathVariable` vs `@RequestParam`?

**Answer:**
- **@PathVariable:** Used to identify a **specific resource**. 
    - *Example:* `/api/users/123` (Retrieving user with ID 123).
- **@RequestParam:** Used for **filtering, sorting, or searching**. It represents optional query parameters.
    - *Example:* `/api/users?role=admin&sort=name` (Searching for admins sorted by name).

---

### 🔹 3. The DTO Pattern
**Q:** Why should we use DTOs instead of passing Entities to the UI?

**Answer:**
- **Encapsulation:** Entities often contain sensitive fields (e.g., password hashes, internal status) that shouldn't be exposed.
- **Decoupling:** Changes in the DB schema (Entity) won't break the public API contract (DTO) if they are mapped correctly.
- **Performance:** DTOs can be optimized to carry only the exact data the UI needs, reducing payload size.

---

### 🔹 4. API Request Validation
**Q:** How do you validate incoming requests in Spring Boot?

**Answer:**
- Use **Jakarta Validation (JSR-380)** annotations on the DTO fields (e.g., `@NotNull`, `@Email`, `@Size`).
- Add the `@Valid` or `@Validated` annotation to the `@RequestBody` parameter in the Controller method.
- If validation fails, Spring throws a `MethodArgumentNotValidException`.

---

### 🔹 5. Global Exception Handling
**Q:** How do you avoid `try-catch` blocks in every Controller method?

**Answer:**
- Use **`@RestControllerAdvice`** and **`@ExceptionHandler`**.
- This allows you to centralize error handling logic. For example, if any controller throws an `EntityNotFoundException`, the global handler intercepts it and returns a consistent `404 Not Found` response with a custom error DTO.

---

### 🔹 6. Spring Profiles
**Q:** How do you handle environment-specific configurations?

**Answer:**
- Use **Spring Profiles**. You can create files like `application-dev.yml` and `application-prod.yml`.
- Activate a profile via the `spring.profiles.active` property or environment variables.
- This allows you to use different DB URLs, credentials, or feature flags for different environments without changing the code.

---

### 🔹 7. @ConfigurationProperties vs @Value
**Q:** Why is `@ConfigurationProperties` preferred over `@Value` for complex configs?

**Answer:**
- **Type Safety:** It maps properties to a structured Java object with full type support.
- **Hierarchical:** It handles nested structures (like Maps and Lists) much better than `@Value`.
- **Validation:** You can use JSR-380 annotations directly on the configuration class.
- **Clarity:** It groups related properties under a common prefix (e.g., `app.security.*`).

---

### 🔹 8. Content Negotiation
**Q:** How does Spring Boot know whether to return JSON or XML?

**Answer:**
- Via **Content Negotiation**. Spring checks the `Accept` header sent by the client.
- If `Accept: application/json` is sent, it uses Jackson to return JSON.
- If `Accept: application/xml` is sent (and the XML dependency is present), it returns XML.
- Jackson is the default JSON library in Spring Boot.
