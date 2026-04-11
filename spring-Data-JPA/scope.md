# 🔴 Spring Boot: Data JPA (Advanced)

This module focuses on the persistence layer, explaining how to map entities, manage relationships, and optimize database performance.

## 🏁 Topics & Descriptions

### 1. The Persistence Engine (Hibernate)
- **Entity**: A Java class mapped to a database table using `@Entity`.
- **Identity Generation**: Using `@GeneratedValue(strategy = GenerationType.IDENTITY)` for auto-incrementing primary keys.
- **Repository Abstraction**: `JpaRepository` provides out-of-the-box methods for CRUD, sorting, and pagination.

### 2. Relationship Management
- **@OneToMany / @ManyToOne**: Modeling parent-child relationships (e.g., Customer has many Orders).
- **Bidirectional Mapping**: Using `mappedBy` to tell Hibernate which side "owns" the relationship.
- **Cascading**: Using `CascadeType.ALL` to propagate operations (like save or delete) from parent to child.

### 3. Performance & Optimization
- **N+1 Query Problem**: A common issue where fetching a list of parents leads to N additional queries for their children.
- **JOIN FETCH**: A JPQL technique to load parent and children in a single SQL query.
- **Projections**: Using Java interfaces to fetch only the specific columns needed for a view, reducing memory and I/O overhead.
- **FetchType.LAZY**: Delaying the loading of related entities until they are actually accessed (Best Practice).

### 4. Querying Strategies
- **Query Methods**: Deriving queries from method names (e.g., `findByEmail`).
- **JPQL**: Writing database-independent queries targeting Java objects.
- **Native Queries**: Writing SQL targeting the specific database dialect for maximum performance.
