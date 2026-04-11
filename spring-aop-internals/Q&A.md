# 🎤 Spring Internals: Interview Q&A

Critical questions and answers covering AOP, Proxies, and Bean Lifecycle hooks.

---

### 🔹 1. JDK Dynamic Proxy vs CGLIB
**Q:** How does Spring implement AOP and `@Transactional` internally?

**Answer:**
- Spring uses **Proxies**.
- **JDK Dynamic Proxy:** Used if the target class implements at least one interface. It creates a proxy implementing the same interfaces.
- **CGLIB:** Used if the class does not implement interfaces. It generates a subclass of the target class at runtime.
- **Note:** Since Spring Boot 2.x, CGLIB is the default.

---

### 🔹 2. The @Around Advice
**Q:** Why is `@Around` the most powerful type of advice in AOP?

**Answer:**
- It gives you full control over the method execution.
- You can decide **when** to call the actual method (`joinPoint.proceed()`), **if** you want to call it at all, and you can even change the return value or catch/rethrow exceptions.

---

### 🔹 3. BeanPostProcessor vs BeanFactoryPostProcessor
**Q:** What is the difference between these two internal hooks?

**Answer:**
- **BeanFactoryPostProcessor:** Executes **before** any beans are instantiated. It can modify the bean definitions (metadata) in the container (e.g., reading properties from a file).
- **BeanPostProcessor:** Executes **after** beans are instantiated but before they are fully initialized (around `@PostConstruct`). It can modify the actual bean instance or wrap it in a proxy.

---

### 🔹 4. Self-Invocation Problem
**Q:** Why does `@Async` or `@Transactional` fail when called from another method in the same class?

**Answer:**
- Spring's magic is in the **Proxy**.
- When you call a method internally using `this.method()`, you are calling the real class, not the proxy. The proxy logic (the transaction or thread switch) is completely bypassed.
- **Fix:** Move the method to a different service class.

---

### 🔹 5. Filter vs Interceptor
**Q:** When would you use a `Filter` instead of an `Interceptor`?

**Answer:**
- **Filter:** Use for low-level concerns that apply to all requests, even those not handled by Spring MVC (like static assets). Good for Logging, Security (CORS/CSRF), and GZIP compression.
- **Interceptor:** Use for Spring MVC specific logic where you need access to the `Handler` (the Controller method) and other Spring beans. Good for Auth checks, timing, and locale handling.

---

### 🔹 6. ApplicationContext Startup Flow
**Q:** Roughly describe the Spring Boot startup flow.

**Answer:**
1. `SpringApplication.run()` is called.
2. The `Environment` is prepared (properties, profiles).
3. The `ApplicationContext` is created.
4. `BeanFactoryPostProcessors` are executed.
5. Beans are instantiated.
6. `BeanPostProcessors` are applied.
7. `CommandLineRunners` are executed after the context is fully ready.
