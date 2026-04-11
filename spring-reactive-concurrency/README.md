# 🔴 spring-reactive-concurrency: High Performance

This project explores the modern, high-performance capabilities of Spring Boot 3.x and Java 21+, focusing on reactive streams and lightweight concurrency.

## 🏁 Architectural Structure

| Package | Purpose | Key Classes |
| :--- | :--- | :--- |
| `controller` | Non-blocking Endpoints | `ReactiveController` (WebFlux) |
| `controller` | Concurrency Metrics | `ConcurrencyController` (Virtual Threads) |

## 🚀 How to Run & Test

### 1. Requirements
- **Java 21** is required to run Virtual Threads.
- **Redis** should be running locally (optional, for Redis features).

### 2. Start the Application
```bash
mvn spring-boot:run
```

### 3. Test WebFlux (Reactive)
- **Single Element**: `GET http://localhost:8080/api/reactive/mono`
- **Streaming Elements**: `GET http://localhost:8080/api/reactive/flux`
  - *Note: Open this in a browser or use `curl` to see the elements appearing one by one every second.*

### 4. Test Virtual Threads (Project Loom)
- **URL**: `GET http://localhost:8080/api/threads/info`
- **Result**: Observe the output. It should say `Executing on: VirtualThread[...]`.
- **Significance**: In standard Spring MVC, this would be a `nio-8080-exec-X` platform thread.

---

## 📂 Project Highlights
- **WebFlux**: Built on Netty, providing a fully non-blocking stack.
- **Virtual Threads**: Enabled via `spring.threads.virtual.enabled=true`.
- **Reactive Stack**: Uses Project Reactor (`Mono`, `Flux`) for asynchronous data flow.
