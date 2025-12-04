# Java & Spring Microservices Development Guidelines

This document defines the mandatory and recommended best practices for Java and Spring Boot microservices development. All contributors must adhere to these standards to ensure consistency, maintainability, and high-quality software delivery.

---

## ✅ **1. Testing Standards**

### **1.1 Unit Testing (Spock Framework)**

* All new code **must include unit tests** using **Spock**.
* Each public method should have **at least one test case**.
* Aim for **>80% code coverage** for new components.
* Mock external dependencies using: `Mock()`, `Spy()`, or `Stub()`.
* Follow BDD-style naming: `given / when / then`.

**Example:**

```groovy
def "should calculate discount correctly"() {
    given:
    def service = new PriceService()

    when:
    def result = service.calculateDiscount(100)

    then:
    result == 90
}
```

---

### **1.2 Integration Testing (Cucumber)**

Use **Cucumber** for all integration tests where:

* A **new endpoint is created**, or
* An **existing endpoint changes behavior or response structure**.

Guidelines:

* Organize scenarios using **Given / When / Then**.
* Place feature files under `src/test/resources/features/`.
* Keep step definitions clean and avoid business logic.
* Validate API responses using REST-assured.

---

## 📚 **2. Documentation Requirements**

### **2.1 Documentation Updates (Mandatory)**

Whenever you introduce a new feature or modify existing behavior, update:

* **README.md** — project overview, setup, run instructions.
* **GEMINI.md** — AI assistant internal guidance.
* **API documentation** (OpenAPI/Swagger).
* **Schemas or architecture diagrams** (if the change impacts architecture).

### **2.2 Javadoc & Comments**

* Add Javadoc for all public methods, classes, and interfaces.
* Add inline comments *only when necessary* to explain complex logic.

---

## 🗄️ **3. Database & Persistence Standards**

### **3.1 Flyway for Database Migrations**

* **All DB changes must be executed using Flyway**.
* Each migration file must be:

    * Versioned (e.g., `V1__init.sql`, `V2__add_user_table.sql`).
    * Idempotent when possible.
* Do not modify previously applied migrations; instead, create new versions.
* Ensure migrations run cleanly on fresh environments.

### **3.2 JPA/Hibernate Best Practices**

* Prefer Spring Data repositories; avoid custom queries unless necessary.
* Use pagination for large query results.
* Avoid `EAGER` loading unless required.
* Use DTOs for responses — *never expose entities directly*.

---

## 🌐 **4. API & Microservices Architecture Standards**

### **4.1 API Design**

* Follow RESTful principles.
* Use consistent naming: `/api/v1/resource`.
* Return meaningful HTTP status codes.
* Implement input validation using Spring Validation (`@Valid`).

### **4.2 Error Handling**

* Use a global exception handler (`@ControllerAdvice`).
* Define unified error response:

```json
{
  "timestamp": "...",
  "error": "...",
  "message": "...",
  "path": "..."
}
```

---

## 🔐 **5. Security Practices**

* Use Spring Security with stateless authentication (JWT/OAuth2).
* Never log sensitive data.
* Sanitize logs and user inputs.
* Validate all inputs even if coming from internal services.
* Keep secrets in Vault/Secret Manager — **never in source code**.

---

## 🧩 **6. Logging & Observability**

* Use structured logging (JSON format preferred).
* Log at the correct levels (INFO for flows, DEBUG for details, ERROR for failures).
* Implement mappers for correlation IDs.
* Add metrics via Micrometer.
* Use distributed tracing (OpenTelemetry).

---

## ⚙️ **7. Performance & Resilience**

* Implement resilience patterns using Resilience4j (retry, circuit breaker, timeouts).
* Avoid blocking operations in reactive services.
* Use connection pooling and set timeouts for external calls.
* Cache expensive operations when possible (Caffeine/Redis).

---

## 📦 **8. Code Quality Standards**

* Follow clean code principles.
* Keep methods short and focused.
* Use meaningful naming for variables and functions.
* Avoid duplicated code (extract common logic).
* Conduct code reviews for all merges.
* Use static code analysis (Checkstyle, SonarQube, SpotBugs).

---

## 🛠️ **9. CI/CD Best Practices**

* Pipeline must include:

    * Unit tests
    * Integration tests
    * Code quality checks
    * Vulnerability scanning
    * Running Flyway migrations
* Artifacts should be immutable.
* Use feature branches and trunk-based development.

---

## 📦 **10. Containerization & Deployment**

* Use multi-stage Docker builds (JDK → JRE runtime).
* Run Spring Boot with a non-root user.
* Use health checks (`/actuator/health`).
* Keep container images minimal.
* Externalize configuration using Spring Config Server or environment variables.

---

## 📘 **Conclusion**

Following these practices ensures:

* High code quality
* Scalable architecture
* Predictable deployments
* Stable and well-tested microservices

All team members must comply with these guidelines for every change, feature, or bug fix.
