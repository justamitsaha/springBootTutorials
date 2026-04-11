# 🟢 Spring Boot: Basics

Focus on understanding the core philosophy of Spring (Inversion of Control) and how Spring Boot simplifies the setup of production-ready applications.

## 1. The "Why" of Spring
- **Tight vs. Loose Coupling:** Understanding why we use interfaces and how Spring manages dependencies.
- **Inversion of Control (IoC):** The shift from manually creating objects to letting the container manage them.
- **Dependency Injection (DI):**
    - Constructor Injection (Best practice)
    - Setter Injection
    - Field Injection (Why to avoid it)

## 2. Spring Core Fundamentals
- **Spring Container (ApplicationContext):** How beans are managed.
- **Bean Lifecycle:** `@PostConstruct` and `@PreDestroy`.
- **Bean Scopes:** Singleton (Default) vs. Prototype.
- **Configuration Styles:**
    - Annotation-based (`@Component`, `@Service`, `@Repository`)
    - Java-based (`@Configuration` and `@Bean`)

## 3. Spring Boot Essentials
- **Auto-Configuration:** How `@EnableAutoConfiguration` works.
- **Spring Boot Starters:** Simplifying dependency management (e.g., `spring-boot-starter-web`).
- **@SpringBootApplication:** Understanding the composition of `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.
- **Embedded Servers:** Tomcat, Jetty, and Undertow.

## 4. Basic Web Development
- **@RestController:** Building simple JSON APIs.
- **Request Mapping:** `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`.
- **Path Variables & Request Params:** Extracting data from URLs.

## 5. Basic Data Access
- **Spring Data JPA:** Creating Entities and Repositories (`CrudRepository`).
- **Database Configuration:** Setting up H2 or MySQL in `application.properties`.

## 6. Configuration Management
- **application.properties / yml:** Basic key-value pairs.
- **@Value:** Injecting simple properties into beans.
