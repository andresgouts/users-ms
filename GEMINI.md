# Project Overview

This is a Java Spring Boot project. The project is a user management microservice.

**Main Technologies:**
*   Java 17
*   Spring Boot 3.2.5
*   Gradle

**Architecture:**
*   The project follows a standard Spring Boot application structure.
*   The main application entry point is `com.example.usersms.UsersMsApplication`.
*   It uses the `spring-boot-starter-web` dependency, which suggests it's a web application, likely exposing REST APIs.

# Building and Running

**Building the project:**
```bash
./gradlew build
```

**Running the project:**
```bash
./gradlew bootRun
```

**Running tests:**
```bash
./gradlew test
```

# Development Conventions

*   The project uses the standard Gradle project structure.
*   The code follows standard Java conventions.
*   the code follows development guidelines specified in gemini/specs/DevGuidelines.md
