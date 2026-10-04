# 🔴 Spring Boot: AOP & Internals (Advanced)

This module explores the internal mechanisms of the Spring Framework, focusing on Aspect-Oriented Programming (AOP), lifecycle processing, and request interception.

## 🏁 Topics & Descriptions

### 1. Aspect Oriented Programming (AOP)
- **Aspect**: A module that encapsulates a cross-cutting concern (e.g., `PerformanceAspect`).
- **Join Point**: A point during the execution of a program, such as the execution of a method.
- **Advice**: Action taken by an aspect at a particular join point (e.g., `@Around`, `@Before`).
- **Pointcut**: A predicate that matches join points (e.g., targeting methods annotated with `@LogExecutionTime`).

### 2. Bean Post Processors
- **BeanPostProcessor**: An interface that allows you to hook into the bean initialization lifecycle.
- **Usage**: Useful for wrapping beans in proxies, logging initialization data, or modifying bean properties before they are fully ready.

### 3. Request Interception
- **HandlerInterceptor**: Intercepts HTTP requests at the Spring MVC level (preHandle, postHandle, afterCompletion).
- **Filter vs Interceptor**: 
    - **Filters**: Part of the Servlet container (outside Spring context).
    - **Interceptors**: Part of the Spring Context (access to Spring beans).

### 4. Async Processing
- **@Async**: Tells Spring to execute a method in a separate thread pool.
- **@EnableAsync**: Enables the detection of `@Async` annotations.
- **Return Type**: Usually returns `void` or `CompletableFuture<T>`.
