# 🎤 Spring Data JPA: Interview Q&A

Critical questions and answers covering Persistence, Relationships, and Performance.

---

### 🔹 1. Hibernate vs Spring Data JPA
**Q:** What is the difference between Hibernate and Spring Data JPA?

**Answer:**
- **Hibernate:** A full-featured ORM (Object Relational Mapping) tool. It is an **implementation** of the JPA specification.
- **Spring Data JPA:** An **abstraction layer** on top of JPA. It reduces boilerplate code by providing repository interfaces (`JpaRepository`) so you don't have to manually write EntityManager code.

---

### 🔹 2. The N+1 Query Problem
**Q:** What is the N+1 problem and how do you solve it?

**Answer:**
- **Problem:** When you fetch a list of N parents (e.g., Customers) and Hibernate executes one query for each parent to fetch their child records (e.g., Orders). This leads to N+1 database hits.
- **Solution:** 
    - Use **`JOIN FETCH`** in JPQL to load parent and children in a single SQL join.
    - Use **`@EntityGraph`** to specify which relationships should be loaded eagerly for a specific method.
    - Use **Projections** if you only need a few fields.

---

### 🔹 3. FetchType.EAGER vs LAZY
**Q:** Which fetch type is the default for `@OneToMany` and why?

**Answer:**
- **LAZY** is the default for `@OneToMany` and `@ManyToMany`. 
- **EAGER** is the default for `@OneToOne` and `@ManyToOne`.
- **Best Practice:** Always prefer **LAZY**. EAGER loading can lead to severe performance issues by loading a massive tree of related entities that are never used.

---

### 🔹 4. Save vs SaveAndFlush
**Q:** When would you use `saveAndFlush()`?

**Answer:**
- **`save()`**: Usually waits until the end of the transaction to actually push the SQL to the database (write-behind).
- **`saveAndFlush()`**: Forces Hibernate to push the changes to the database **immediately**. This is useful if you need to perform an operation (like a native SQL query) in the same transaction that depends on the newly saved data.

---

### 🔹 5. Bidirectional Mapping
**Q:** What is the purpose of the `mappedBy` attribute?

**Answer:**
- It is used in bidirectional relationships to specify the **non-owning** side.
- It tells Hibernate: "This field is just a reference; the real mapping (and the foreign key) is managed by the field named 'X' in the other entity."
- Without `mappedBy`, Hibernate would create two separate mapping tables or duplicate foreign keys.

---

### 🔹 6. JPA Projections
**Q:** Why are Interface Projections better than DTO classes in JPA?

**Answer:**
- **Efficiency:** Projections generate more optimized SQL by only selecting the specific columns needed (`SELECT name FROM ...`).
- **Simplicity:** Spring Data JPA automatically creates a proxy implementation for the interface at runtime, so you don't have to write any boilerplate DTO code or mapping logic.

---

### 🔹 7. Transactional Proxy Failures
**Q:** Why does calling a `@Transactional` method from another method in the same class fail to start a transaction?

**Answer:**
- Spring uses **JDK Dynamic Proxies** or CGLIB. The transaction logic is inside the proxy.
- When you call a method internally (`this.method()`), you bypass the proxy and call the real class directly.
- **Fix:** Move the transactional logic to a different service, or use `self-injection` (though discouraged).

---

### 🔹 8. Propagation Levels
**Q:** What is the difference between `REQUIRED` and `REQUIRES_NEW`?

**Answer:**
- **REQUIRED:** (Default) Join the existing transaction if one exists; create a new one otherwise.
- **REQUIRES_NEW:** Always suspend the current transaction and create a new, independent transaction. If the inner transaction fails, it doesn't necessarily roll back the outer one.
