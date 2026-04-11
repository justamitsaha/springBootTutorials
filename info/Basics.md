# 🟢 Spring Boot: Basics (Comprehensive)

This level covers the foundational mechanics of the Spring Framework that every developer must master before touching advanced Spring Boot features.

## 1. Core Principles (The Foundation)
- **Coupling:** Tight vs. Loose coupling (using interfaces).
- **Inversion of Control (IoC):** Understanding that the container, not the dev, manages objects.
- **Dependency Injection (DI):**
    - Constructor Injection (**Preferred**).
    - Setter Injection.
    - Field Injection (Avoid in production).

## 2. The Spring Container
- **BeanFactory vs. ApplicationContext:**
    - `BeanFactory`: Basic IoC container.
    - `ApplicationContext`: Advanced container with AOP, I18N, and Event support.
- **Bean Management:** How the container creates, configures, and manages bean lifecycles.

## 3. Bean Basics & Stereotypes
- **Defining Beans:**
    - `@Component`: Automated scanning.
    - `@Bean`: Manual definition in `@Configuration` classes.
- **Stereotype Annotations:**
    - `@Component` (Generic)
    - `@Service` (Business logic)
    - `@Repository` (Data access/DAO)
    - `@Controller` / `@RestController` (Web/API)

## 4. DI Deep Dive (Resolution)
- **`@Autowired`**: Automatic dependency resolution.
- **`@Primary`**: Default bean to use when multiple candidates exist.
- **`@Qualifier`**: Specifically naming which bean to inject.
- **Resolution Order:** How Spring decides which bean to pick.
- **Circular Dependencies:** Basics of what they are and why to avoid them.

## 5. Bean Lifecycle (The Pipeline)
- **Lifecycle Phases:** Instantiation → DI → Initialization → Destruction.
- **Hooks:** `@PostConstruct` and `@PreDestroy`.
- **Aware Interfaces:** `BeanNameAware`, `ApplicationContextAware` (understanding how a bean "sees" its container).

## 6. Bean Scopes
- **Singleton (Default):** One instance per container.
- **Prototype:** New instance per request.
- **Web Scopes:** Request, Session, Application (requires Spring Web).
- **Thread Safety:** Discussion on Singleton beans in a multi-threaded environment.

## 7. Configuration Styles
- **Java-based Config:** Using `@Configuration` and `@Bean`.
- **Component Scanning:** Using `@ComponentScan` and understanding base packages.
- **XML Config:** (Legacy) Understanding its existence for maintenance roles.

## 8. Initialization Strategies
- **Eager Initialization:** Default behavior for Singletons.
- **Lazy Initialization:** Using `@Lazy` to delay creation until first use.

## 9. Spring Framework vs. Spring Boot
- **Core Spring:** The engine (DI, AOP, SpEL).
- **Spring Boot:** The wrapper (Auto-config, Starters, Actuator).

## 10. AOP Basics (Introduction)
- **Core Concepts:** Aspect, Advice, Join Point, Pointcut.
- **Use Cases:** Logging, Transactions, Security.
