# 🎤 Spring Security: Interview Q&A

Critical questions and answers covering Authentication, Authorization, JWT, and OAuth2.

---

### 🔹 1. Stateless vs Stateful Security
**Q:** What is the difference between Stateless and Stateful authentication in Spring Security?

**Answer:**
- **Stateful:** The server creates a **Session** after login and stores it in memory (or Redis). It sends a `JSESSIONID` cookie to the client. The server must remember the user.
- **Stateless:** The server does not store any user state. After login, it sends a **JWT** to the client. The client sends this token in the header of every request. The server validates the token on every hit. **(Best for Microservices)**.

---

### 🔹 2. How JWT Works
**Q:** What are the three parts of a JWT and how are they secured?

**Answer:**
- **Header:** Contains the algorithm (e.g., HS256) and token type.
- **Payload:** Contains the claims (e.g., username, roles, expiry).
- **Signature:** A cryptographic hash of the Header + Payload + a Secret Key. 
- **Security:** The signature ensures the payload hasn't been tampered with. Only someone with the secret key can verify or create a valid signature.

---

### 🔹 3. The Filter Chain
**Q:** What is the `SecurityFilterChain` and why is it important?

**Answer:**
- It is a chain of Servlet Filters that Spring Security uses to process requests.
- It handles tasks like CSRF protection, Authentication (checking credentials), and Authorization (checking roles).
- In modern Spring Security, you configure it using a `@Bean` of type `SecurityFilterChain`.

---

### 🔹 4. BCrypt Password Encoding
**Q:** Why shouldn't we use MD5 or SHA-256 for storing passwords? What is better?

**Answer:**
- MD5 and SHA-256 are too fast, making them vulnerable to brute-force and rainbow table attacks.
- **BCrypt** is preferred because it is a "slow" hashing algorithm. It includes a **salt** (to prevent rainbow tables) and a **work factor** (to make it computationally expensive for hackers).

---

### 🔹 5. Method Level Security
**Q:** How do you restrict access to a specific Java method based on user roles?

**Answer:**
- Annotate your configuration class with `@EnableMethodSecurity`.
- Use the **`@PreAuthorize`** annotation on the method.
- *Example:* `@PreAuthorize("hasRole('ADMIN')")` will throw an `AccessDeniedException` if a non-admin tries to call the method.

---

### 🔹 6. CORS vs CSRF
**Q:** What is the difference between CORS and CSRF?

**Answer:**
- **CORS (Cross-Origin Resource Sharing):** A browser security feature that restricts web pages from making requests to a different domain than the one that served the page. You must configure it to allow your Frontend (e.g., React on port 3000) to talk to your Backend (port 8080).
- **CSRF (Cross-Site Request Forgery):** An attack where a malicious site tricks a logged-in user into performing an action on another site. Spring Security provides protection by requiring a unique token for state-changing requests (POST, PUT, DELETE). CSRF is often disabled in stateless JWT APIs.

---

### 🔹 7. OAuth2 and OIDC
**Q:** What is the difference between OAuth2 and OpenID Connect (OIDC)?

**Answer:**
- **OAuth2:** An **Authorization** framework. It allows an app to "act on behalf of a user" (e.g., "Post a tweet for me").
- **OIDC:** An **Authentication** layer on top of OAuth2. It provides user identity information (e.g., "Who is this user?"). It uses an `ID Token` in addition to the `Access Token`.
