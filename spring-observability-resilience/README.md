# 🔴 spring-observability-resilience: Production Excellence

This project demonstrates how to build resilient Spring Boot applications with comprehensive monitoring and fault tolerance.

## 🏁 Architectural Structure

| Package | Purpose | Key Classes |
| :--- | :--- | :--- |
| `service` | Fault Tolerant Logic | `ResilientService` (@CircuitBreaker, @Retry) |
| `health` | Custom Monitoring | `CustomHealthIndicator` |
| `controller` | Observability APIs | `ObservationController` |

## 🚀 How to Run & Test

### 1. Start the Application
```bash
mvn spring-boot:run
```

### 2. Test Fault Tolerance (Circuit Breaker)
Hit the endpoint multiple times:
- **URL**: `GET http://localhost:8080/api/obs/circuit-breaker`
- **Observation**: After a few failures, the circuit will **OPEN**, and you will receive the fallback response immediately without the service even trying the "slow" call.

### 3. Test Retries
- **URL**: `GET http://localhost:8080/api/obs/retry`
- **Observation**: Check the console logs. You will see 3 attempts before the fallback is finally returned.

### 4. Inspect Health & Metrics
- **All Health**: [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)
  - You will see the `CustomHealthIndicator` details here.
- **Metrics List**: [http://localhost:8080/actuator/metrics](http://localhost:8080/actuator/metrics)
- **HTTP Requests Metric**: [http://localhost:8080/actuator/metrics/http.server.requests](http://localhost:8080/actuator/metrics/http.server.requests)

---

## 📂 Project Highlights
- **Resilience4j**: Declarative fault tolerance.
- **Actuator**: Full transparency into application internals.
- **Tracing**: Brave/Micrometer integration ready for Zipkin.
