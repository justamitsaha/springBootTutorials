# 🟢 spring-Basic: Core Spring Concepts

This project is a modular deep-dive into the foundational mechanics of the Spring Framework. Features are broken down into individual packages, each with its own **Runner** class to isolate and demonstrate a specific concept.

## 🏁 How to Run Individual Features

To run a specific concept, execute the corresponding **Runner** class. Since this project contains multiple main methods, you can run them via your IDE (Right-click -> Run) or via the command line.

### 1. Coupling (Tight vs Loose)
- **Runner:** `com.saha.amit.spring_Basic.A_coupling.CouplingRunner`
- **Focus:** Demonstrates how to use interfaces (`GameRunner`) to decouple code. This is a pure Java example showing the "Why" behind Spring.

### 2. Dependency Injection (DI) & Resolution
- **Runner:** `com.saha.amit.spring_Basic.dependencyInjection.DIRunner`
- **Focus:** 
    - Constructor Injection (`BusinessLogic.java`).
    - DI Resolution using `@Primary` and `@Qualifier`.

### 3. Bean Lifecycle & Scopes
- **Runner:** `com.saha.amit.spring_Basic.lifecycle.LifecycleRunner`
- **Focus:**
    - Singleton vs. Prototype Scopes.
    - Lifecycle Hooks (`@PostConstruct`, `@PreDestroy`).
    - Lazy Initialization (`@Lazy`).

### 4. AOP (Aspect Oriented Programming)
- **Runner:** `com.saha.amit.spring_Basic.aop.AopRunner`
- **Focus:** Intercepting business logic methods using `@Aspect` to apply cross-cutting concerns like logging.

---

## 📂 Feature to Code Mapping

| Package | Feature | Key Classes |
| :--- | :--- | :--- |
| `coupling` | Loose Coupling | `GameRunner`, `MarioGame`, `GameConsole` |
| `di` | Constructor Injection | `BusinessLogic`, `SimpleService` |
| `di` | DI Resolution | `SearchService` (@Primary), `HighPrioritySearchService` (@Qualifier) |
| `di` | Circular Dependency | `CircularDependencyExample` (@Lazy resolution) |
| `lifecycle` | Scopes & Hooks | `LifecycleExample` (@PostConstruct) |
| `lifecycle` | Advanced Lifecycle | `AdvancedLifecycle` (Aware Interfaces, @Lazy) |
| `config` | Java Configuration | `AppConfig` (@Configuration, @Bean) |
| `aop` | Aspect Interception | `LoggingAspect` (@Before) |

---

## 🚀 Maven Command Line Execution
If you wish to run a specific runner from the command line, use:
```bash
mvn spring-boot:run -Dspring-boot.run.main-class=com.saha.amit.spring_Basic.dependencyInjectionpendencyInjection.DIRunner
```
*(Replace the class path with the desired runner)*
