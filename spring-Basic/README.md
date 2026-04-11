# 🟢 spring-Basic: Core Spring Concepts

This project is a deep-dive into the foundational mechanics of the Spring Framework, implemented using Spring Boot 3.x.

## 🏁 Feature to Code Mapping

### 1. Coupling (Tight vs Loose)
- **Package:** `com.saha.amit.spring_Basic.coupling`
- **Classes:** `CouplingExample.java`, `GameRunner` (Interface), `MarioGame`, `SuperContra`, `GameConsole`.
- **Purpose:** Demonstrates how to use interfaces to decouple code, which is the core problem Spring solves.

### 2. Dependency Injection (DI) & Resolution
- **Package:** `com.saha.amit.spring_Basic.di`
- **Constructor Injection:** `BusinessLogic.java` (Recommended).
- **Setter Injection:** `NotificationService` in `DIExample.java`.
- **@Primary:** `SortingAlgorithm.java` -> `QuickSort`.
- **@Qualifier:** `SortingAlgorithm.java` -> `BubbleSort`.
- **Ambiguity Resolution:** `SearchService.java` vs `HighPrioritySearchService.java`.
- **Circular Dependency:** `CircularDependencyExample.java` (shows resolution via `@Lazy`).

### 3. Bean Basics & Stereotypes
- **Package:** `com.saha.amit.spring_Basic.stereotypes`
- **Classes:** `StereotypeExample.java`, `UserRepo` (`@Repository`), `UserService` (`@Service`).
- **Java Configuration:** `com.saha.amit.spring_Basic.config.AppConfig.java` (uses `@Configuration` and `@Bean`).

### 4. Bean Lifecycle & Scopes
- **Package:** `com.saha.amit.spring_Basic.lifecycle`
- **Scopes (Singleton/Prototype):** `LifecycleExample.java`.
- **Lifecycle Hooks (@PostConstruct/@PreDestroy):** `LifecycleExample.java`.
- **Lazy Initialization (@Lazy):** `AdvancedLifecycle.java`.
- **Aware Interfaces:** `AdvancedLifecycle.java` -> `AwareBean` (implements `BeanNameAware`, `ApplicationContextAware`).

### 5. AOP (Aspect Oriented Programming)
- **Package:** `com.saha.amit.spring_Basic.aop`
- **Classes:** `LoggingAspect.java`.
- **Purpose:** Intercepts methods in the `di` package to demonstrate cross-cutting concerns.

---

## 🚀 How to Run
1. Navigate to the `spring-Basic` directory.
2. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```
3. Watch the console logs for the structured output explaining each feature in real-time.

## 📂 Core Package Structure
- `SpringBasicApplication.java`: The main entry point where beans are retrieved and demonstrated.
- `target/`: Generated classes after compilation.
