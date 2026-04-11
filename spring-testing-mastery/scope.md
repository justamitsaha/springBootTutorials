# 🔴 Spring Boot: Testing Mastery (Advanced)

This module focuses on the transition from basic unit testing to professional, multi-layered testing strategies using real infrastructure and architectural enforcement.

## 🏁 Topics & Descriptions

### 1. Slice Testing
- **@DataJpaTest**: Loads only the JPA-related beans (Repositories, EntityManager). Fastest way to test the persistence layer.
- **@WebMvcTest**: Loads only the web-related beans (Controllers). Use `MockMvc` to simulate HTTP requests and `MockBean` to mock the service layer.

### 2. Infrastructure Testing (Testcontainers)
- **Concept**: Using Docker containers to run real instances of databases (Postgres, MySQL), message brokers (Kafka), or caches (Redis) during integration tests.
- **Benefit**: Eliminates the "Works on H2 but fails on Postgres" problem.
- **@ServiceConnection**: A Spring Boot 3.1+ feature that automatically configures the datasource to point to the Docker container.

### 3. Architecture Enforcement (ArchUnit)
- **Concept**: Writing tests that analyze your Java bytecode to check for architectural violations.
- **Rules**: For example, "Controllers must not call Repositories" or "Service names must end with 'Service'".

### 4. Integration Testing
- **@SpringBootTest**: Loads the full ApplicationContext.
- **RANDOM_PORT**: Starts the server on a random available port to avoid conflicts during CI/CD builds.
