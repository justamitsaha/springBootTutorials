# 🎤 Spring Core: Interview Q&A

This document contains critical interview questions and answers based on the core Spring concepts covered in this project.

---

### 🔹 1. Tight vs. Loose Coupling
**Q:** Why is loose coupling important in a Spring application?

**Answer:**
- Loose coupling means a class is not dependent on a specific implementation but rather on an abstraction (Interface).
- This allows for easier testing (mocking), maintainability, and flexibility to swap implementations without changing the dependent class.
- **Example:** `GameConsole` depends on `GameRunner` (interface), not `MarioGame` specifically.

---

### 🔹 2. Inversion of Control (IoC)
**Q:** What is Inversion of Control (IoC) and who is responsible for it?

**Answer:**
- IoC is the design principle where the control of object creation and lifecycle is "inverted" from the developer to the framework.
- In Spring, the **IoC Container** (Spring Container) is responsible for instantiating, configuring, and assembling the beans.

---

### 🔹 3. Dependency Injection (DI) Types
**Q:** Compare Constructor Injection vs. Setter Injection. Which is preferred?

**Answer:**
- **Constructor Injection:** Dependencies are provided during object creation. It ensures that required dependencies are not null and allows for immutable objects (`final` fields). **(Preferred)**
- **Setter Injection:** Dependencies are provided via setter methods. It is useful for optional dependencies or when you need to change a dependency after creation.

---

### 🔹 4. BeanFactory vs. ApplicationContext
**Q:** What is the difference between `BeanFactory` and `ApplicationContext`?

**Answer:**
- **BeanFactory:** The basic version of the container. It is "lazy" (loads beans on request) and is suitable for memory-constrained environments.
- **ApplicationContext:** The advanced version that extends `BeanFactory`. It is "eager" (loads singletons at startup) and adds features like AOP, Internationalization (I18N), and event handling.

---

### 🔹 5. @Component vs. @Bean
**Q:** When would you use `@Bean` instead of `@Component`?

**Answer:**
- **@Component:** Used for classes you own. It relies on classpath scanning to automatically register the class as a bean.
- **@Bean:** Used in `@Configuration` classes. It is preferred when you don't own the source code (e.g., 3rd party libraries) or when you need explicit, complex initialization logic for a bean.

---

### 🔹 6. @Primary vs. @Qualifier
**Q:** How does Spring handle multiple beans of the same type?

**Answer:**
- Spring will throw a `NoUniqueBeanDefinitionException` unless resolved.
- **@Primary:** Marks a "default" bean to be used.
- **@Qualifier:** Allows you to specify the exact bean name at the injection point, providing higher precision than `@Primary`.

---

### 🔹 7. Circular Dependencies
**Q:** How do you resolve a circular dependency in Spring?

**Answer:**
- A circular dependency occurs when Bean A needs Bean B, and Bean B needs Bean A.
- **Fix:** 
    - Refactor the code to break the cycle (Best practice).
    - Use `@Lazy` on one of the injection points to tell Spring to create a proxy instead of the full bean initially.

---

### 🔹 8. Bean Lifecycle Hooks
**Q:** Explain `@PostConstruct` and `@PreDestroy`.

**Answer:**
- **@PostConstruct:** Executed after the bean has been instantiated and all dependencies have been injected. Used for initialization logic.
- **@PreDestroy:** Executed just before the bean is removed from the application context. Used for cleanup (e.g., closing database connections).

---

### 🔹 9. Singleton vs. Prototype Scope
**Q:** What happens if you inject a `Prototype` bean into a `Singleton` bean?

**Answer:**
- By default, the `Prototype` bean will only be injected **once** when the `Singleton` bean is created.
- To get a new instance of the `Prototype` bean every time, you must use an `ObjectProvider`, `@Lookup`, or request it directly from the `ApplicationContext`.

---

### 🔹 10. Aspect-Oriented Programming (AOP)
**Q:** What are the key concepts of AOP?

**Answer:**
- **Aspect:** The modularization of a cross-cutting concern (e.g., Logging).
- **Advice:** The action taken at a particular join point (e.g., `@Before`, `@After`).
- **Pointcut:** An expression that identifies which join points (methods) will be intercepted.
- **Join Point:** A specific point in the execution of the application (e.g., method call).
