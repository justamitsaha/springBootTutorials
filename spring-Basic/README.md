# 🟢 spring-Basic: Core Spring Concepts

This project is a modular deep-dive into the foundational mechanics of the Spring Framework. Each concept is isolated into its own package and a **single-file Runner** for easier study and experimentation.

## 🏁 How to Run Individual Features

To run a specific concept, execute the corresponding **Runner** class from your IDE or the command line.

### 1. A_coupling (Tight vs Loose)
- **Runner:** `com.saha.amit.spring_Basic.A_coupling.CouplingRunner`
- **Concept:** Demonstrates how interfaces decouple code. Pure Java example (no Spring).

### 2. B_dependencyInjection
- **Runners:**
    - `DIRunner.java`: Compares Constructor (Best Practice), Field (Bad), and Setter (Optional) injection.
    - `QualifiersRunner.java`: Demonstrates `@Primary` vs `@Qualifier` resolution.
    - `CircularDependencyRunner.java`: Shows how `@Lazy` resolves circular references.

### 3. C_lifecycle
- **Runner:** `com.saha.amit.spring_Basic.C_lifecycle.LifecycleRunner`
- **Concept:** Singleton vs. Prototype Scopes, `@PostConstruct`/`@PreDestroy` hooks, and `Aware` interfaces.

### 4. D_stereotypes
- **Runner:** `com.saha.amit.spring_Basic.D_stereotypes.StereotypeRunner`
- **Concept:** Proper use of `@Service` (Business Layer) and `@Repository` (Data Layer).

### 5. E_config
- **Runner:** `com.saha.amit.spring_Basic.E_config.ConfigRunner`
- **Concept:** Java-based configuration using `@Configuration` and `@Bean`.

### 6. F_aop
- **Runner:** `com.saha.amit.spring_Basic.F_aop.AopRunner`
- **Concept:** Basic Aspect Oriented Programming (AOP) for cross-cutting concerns like logging.

---

## 🚀 Maven Command Line Execution
To run a specific runner:
```bash
mvn spring-boot:run -Dspring-boot.run.main-class=com.saha.amit.spring_Basic.B_dependencyInjection.DIRunner
```

---

## 📂 Best Practice Summary
- **Constructor Injection**: Always use for mandatory dependencies (allows `final` fields).
- **Setter Injection**: Use for optional dependencies or breaking circular cycles.
- **Field Injection**: Avoid! It hides dependencies and makes unit testing difficult.
- **Singleton**: Default scope for stateless services.
- **Stereotypes**: Use `@Service` and `@Repository` for better architectural clarity.
