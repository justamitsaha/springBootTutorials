# 🎤 High-Performance Spring: Interview Q&A

Critical questions and answers covering WebFlux, Virtual Threads, and Concurrency.

---

### 🔹 1. Web MVC vs. WebFlux
**Q:** When would you choose Spring WebFlux over Spring Web MVC?

**Answer:**
- **Web MVC:** Best for traditional applications with blocking I/O (most JDBC drivers) and moderate concurrency. It uses the **thread-per-request** model.
- **WebFlux:** Best for high-concurrency applications where you need to scale with few threads. It is ideal for **I/O bound** tasks (calling multiple slow APIs) and systems using non-blocking drivers (R2DBC, Reactive Redis).

---

### 🔹 2. Virtual Threads (Project Loom)
**Q:** How do Virtual Threads solve the scalability problem in Java?

**Answer:**
- **Platform Threads:** Are wrappers around OS threads. They are expensive (approx 1MB memory each) and context switching is slow.
- **Virtual Threads:** Managed by the JVM. They are extremely lightweight (approx 1KB) and context switching happens in user-space.
- **Win:** You can run millions of Virtual Threads on a single server, making blocking I/O almost as efficient as non-blocking code without the complexity of Reactive streams.

---

### 🔹 3. Mono vs. Flux
**Q:** What is the difference between `Mono` and `Flux`?

**Answer:**
- **Mono:** A Publisher that emits 0 or 1 item and then completes. (e.g., fetching a user by ID).
- **Flux:** A Publisher that emits 0 to N items and then completes or errors. (e.g., streaming real-time stock prices).

---

### 🔹 4. Reactive Streams: Backpressure
**Q:** What is "Backpressure" in Reactive Programming?

**Answer:**
- Backpressure is a mechanism where the **Consumer** tells the **Producer** how much data it can handle.
- **Purpose:** Prevents a fast producer from overwhelming a slow consumer, which would otherwise lead to out-of-memory errors or system crashes.

---

### 🔹 5. The "Netty" Server
**Q:** Why does WebFlux use Netty by default instead of Tomcat?

**Answer:**
- **Tomcat:** Designed for blocking, servlet-based models. While it supports async, its core is thread-per-request.
- **Netty:** A non-blocking, event-driven network framework. It is natively built for high-performance, asynchronous communication, which aligns perfectly with the Reactive model.

---

### 🔹 6. Distributed Caching (Redis)
**Q:** Why use Reactive Redis instead of standard Jedis/Lettuce?

**Answer:**
- Standard Redis clients block the thread while waiting for a response from the Redis server.
- **Reactive Redis:** Uses non-blocking I/O. The calling thread is released immediately, and the response is handled via a callback (`Mono`/`Flux`), maintaining the end-to-end non-blocking nature of the WebFlux stack.
