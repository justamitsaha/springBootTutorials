# 🔴 spring-aop-internals: The "Magic" of Spring

This project explores the internal mechanisms of the Spring Framework, specifically how AOP, lifecycle hooks, and proxies work to enable declarative features.

## 🏁 Architectural Structure

| Package | Purpose | Key Classes |
| :--- | :--- | :--- |
| `annotation` | Custom Markers | `@LogExecutionTime` |
| `aspect` | Cross-Cutting Logic | `PerformanceAspect` (@Around) |
| `postprocessor` | Lifecycle Hooks | `CustomBeanPostProcessor` |
| `interceptor` | Request Hooking | `ExecutionInterceptor` |
| `service` | Business Logic | `BusinessService` (@Async) |
| `controller` | API Entry points | `InternalsController` |

## 🚀 How to Run & Test

### 1. Start the Application
```bash
mvn spring-boot:run
```

### 2. Observe BeanPostProcessor
Watch the console logs during startup. You will see lines like:
`[Internals] Service Bean Initialized: businessService`
This proves that the `BeanPostProcessor` is active and intercepting bean creation.

### 3. Test AOP (@LogExecutionTime)
- **URL**: `GET http://localhost:8080/api/internals/aop`
- **Result**: The endpoint returns "Slow method finished".
- **Console**: Observe the log: `[AOP] ... slowMethod executed in 10xxms`.

### 4. Test Async Processing
- **URL**: `GET http://localhost:8080/api/internals/async`
- **Result**: The request returns immediately (or follows the future).
- **Console**: Observe that the controller and the service execute in **different threads**.

### 5. Observe Interceptor
Hit any endpoint and check the console for:
`[Interceptor] PreHandle: Intercepting request to /api/internals/...`

---

## 📂 Project Highlights
- **Proxies**: Understand that when you call `slowMethod()`, you are actually calling a Spring-generated Proxy that measures the time before delegating to the real method.
- **Declarative Power**: See how a simple annotation like `@Async` completely changes how Java executes code.
