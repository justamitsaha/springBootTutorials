# 🎤 Observability & Resilience: Interview Q&A

Critical questions and answers covering Monitoring, Fault Tolerance, and Tracing.

---

### 🔹 1. Spring Boot Actuator
**Q:** What is Spring Boot Actuator and name some important endpoints?

**Answer:**
- Actuator is a sub-project that adds production-ready monitoring and management features to your app.
- **Endpoints:**
    - `/actuator/health`: Shows application health status.
    - `/actuator/metrics`: Shows various metrics (CPU, Memory, HTTP).
    - `/actuator/loggers`: Allows viewing and changing log levels at runtime.
    - `/actuator/threaddump`: Dumps the current thread state.

---

### 🔹 2. Circuit Breaker Pattern
**Q:** How does a Circuit Breaker work and what are its states?

**Answer:**
- It protects a system from cascading failures by "tripping" when a downstream service fails repeatedly.
- **States:**
    - **CLOSED:** Normal operation. Requests flow through.
    - **OPEN:** Failure threshold exceeded. Requests are blocked and return a fallback immediately.
    - **HALF_OPEN:** After a wait duration, the breaker allows a few requests to see if the service has recovered.

---

### 🔹 3. Retry vs. Circuit Breaker
**Q:** When would you use Retry vs. a Circuit Breaker?

**Answer:**
- **Retry:** Use for **transient** (short-lived) errors like a network blip. You expect it to work if you try again in a few milliseconds.
- **Circuit Breaker:** Use for **persistent** failures. If a service is down, retrying 1000 times will only exhaust your own resources and hammer the failing service.

---

### 🔹 4. Distributed Tracing
**Q:** What are Trace IDs and Span IDs?

**Answer:**
- **Trace ID:** A unique ID for a single user request across all microservices. It links all logs for that specific request.
- **Span ID:** A unique ID for a request's work within a **single** service. A single Trace is made of multiple Spans.

---

### 🔹 5. Bulkhead Pattern
**Q:** What is the Bulkhead pattern in Resilience4j?

**Answer:**
- It isolates system resources (like thread pools or semaphores) for different service calls. 
- **Purpose:** If Service A is slow and consuming all threads, the Bulkhead ensures Service B still has its own dedicated threads to continue working.

---

### 🔹 6. Custom Health Indicators
**Q:** How do you add a custom health check to Spring Boot?

**Answer:**
- Create a class that implements the `HealthIndicator` interface.
- Override the `health()` method and return a `Health` object (UP or DOWN) with optional details.
- Spring Boot automatically picks it up and exposes it under `/actuator/health`.
