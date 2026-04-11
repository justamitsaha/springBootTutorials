# 🔴 Spring Boot: Reactive & Concurrency (Advanced)

This module focuses on the modern, high-performance side of the Java and Spring ecosystem, covering non-blocking I/O and lightweight concurrency.

## 🏁 Topics & Descriptions

### 1. Virtual Threads (Project Loom)
- **Concept**: Lightweight threads managed by the JVM instead of the OS.
- **Benefit**: Allows scaling to millions of concurrent requests without the memory overhead of traditional "Platform" threads.
- **Usage**: Enabled in Spring Boot 3.2+ via `spring.threads.virtual.enabled=true`.

### 2. Reactive Programming (WebFlux)
- **Spring WebFlux**: A fully non-blocking, reactive web framework.
- **Mono**: A reactive stream that emits 0 or 1 element.
- **Flux**: A reactive stream that emits 0 to N elements (useful for event streams).
- **Project Reactor**: The core library powering WebFlux.

### 3. Non-Blocking I/O
- **Concept**: Instead of a thread waiting for a database or API response, it is released to do other work and "called back" when the data is ready.
- **Starter**: `spring-boot-starter-webflux`.

### 4. Distributed Caching (Reactive Redis)
- **Concept**: High-speed, in-memory data storage used to reduce database load.
- **Reactive Stack**: Using `ReactiveRedisTemplate` to ensure the caching layer doesn't block threads.
