# 🔹 1. Core Principles (Foundation)
- **Tight coupling vs Loose coupling**: Designing code so classes aren't dependent on specific implementations, making it flexible.
- **IoC (Inversion of Control)**: Delegating the control of object creation and lifecycle to the Spring Container.
- **Dependency Injection (DI)**: The process of the container providing required objects (dependencies) to a class.
    - **Constructor injection**: (Preferred) Dependencies passed through the constructor; ensures mandatory dependencies are met.
    - **Setter injection**: Dependencies provided via setter methods; useful for optional dependencies.
    - **Field injection**: Injected directly into fields using `@Autowired`; easy but hard to test and not recommended.

---

# 🔹 2. Spring Container
- **Spring Container**: The engine that manages beans, configurations, and lifecycles.
- **BeanFactory**: The basic version of the container providing DI support.
- **ApplicationContext**: The advanced container adding enterprise features like AOP, I18N, and events.

---

# 🔹 3. Bean Basics
- **Bean**: Any object managed by the Spring IoC container.
- **@Component**: Automatically detects and registers a class as a bean using classpath scanning.
- **@Bean**: Manually defines a bean inside a `@Configuration` class; used for 3rd party libraries.
- **Stereotypes**: Specialized annotations for architectural layers:
    - `@Component`: Generic bean.
    - `@Service`: Business logic layer.
    - `@Repository`: Data access/Persistence layer.
    - `@Controller`: Web/API presentation layer.

---

# 🔹 4. Dependency Injection Deep Dive
- **@Autowired**: Marks a dependency for automatic resolution and injection.
- **@Qualifier**: Resolves ambiguity when multiple beans of the same type exist by specifying a name.
- **@Primary**: Sets a default bean to be used when multiple candidates are available.
- **Circular dependency**: When Bean A needs Bean B and vice versa; resolved via `@Lazy` or design refactoring.

---

# 🔹 5. Bean Lifecycle
- **Lifecycle phases**: Instantiation -> DI -> Initialization -> Destruction.
- **@PostConstruct**: Method that runs immediately after the bean is initialized.
- **@PreDestroy**: Method that runs just before the bean is removed from the context.
- **Aware interfaces**: Interfaces like `BeanNameAware` that let a bean "know" about its context properties.

---

# 🔹 6. Bean Scope
- **Singleton**: (Default) Only one instance per Spring container; shared by all.
- **Prototype**: A new instance is created every time the bean is requested.
- **Web scopes**: Scopes tied to HTTP lifecycle (Request, Session, Application).

---

# 🔹 7. Configuration
- **Java-based config**: Using `@Configuration` classes and `@Bean` methods instead of XML.
- **@ComponentScan**: Tells Spring which packages to scan for annotated components.

---

# 🔹 8. Lazy vs Eager Initialization
- **@Lazy**: Tells Spring to create the bean only when it's first used, not at startup.
- **Default behavior**: Singleton beans are eagerly created at startup for fast runtime access.

---

# 🔹 9. Spring Context vs Boot
- **Core Spring**: The DI engine and foundational framework.
- **Spring Boot**: A wrapper that simplifies Spring setup via auto-configuration and starters.

---

# 🔹 10. AOP (Aspect Oriented Programming)
- **Aspect**: A module that encapsulates "cross-cutting concerns" like logging.
- **Advice**: The action taken by an aspect (Before, After, Around).
- **Pointcut**: An expression that determines which methods the advice should apply to.
