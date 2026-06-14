# Spring + Angular — Full-stack Study / Portfolio (WIP)

A full-stack project built to deepen my Java/Spring skills, structured around
a **user management & authentication** domain. The backend is a Spring Boot
REST API with Spring Security; the frontend is an Angular SPA. Originally a
study sandbox, it's evolving into a portfolio site.

> 🚧 **Status:** work in progress — actively being refactored and expanded.

## Tech Stack

**Backend:** Java 21 · Spring Boot 3.4.3 · Spring Data JPA · Spring Security ·
Hibernate Validator (Jakarta Validation) · Spring Boot Actuator · MySQL · Maven
**Testing:** JUnit · Mockito
**Frontend:** Angular 19 · TypeScript

## Backend Highlights

The backend follows a clean, feature-oriented package structure with clear
separation of responsibilities:

```
com.example.app
├── Application.java
├── config/
│   ├── SecurityConfig.java          # Spring Security configuration
│   └── PasswordEncoderConfig.java   # password hashing bean
├── exception/
│   ├── GlobalExceptionHandler.java  # centralized error handling (@RestControllerAdvice)
│   ├── ApiException.java
│   └── ErrorResponse.java
├── user/
│   ├── controller/   # REST endpoints
│   ├── service/      # business logic
│   ├── repository/   # Spring Data JPA
│   ├── model/        # JPA entities
│   └── dto/          # request/response DTOs (register, login)
└── utils/
    ├── ValidPassword.java           # custom validation annotation
    ├── ConstraintPatterns.java
    └── ValidationMessages.java
```

Key practices demonstrated:

- **Authentication** — user registration and login with password encoding via
  Spring Security.
- **Custom validation** — a `@ValidPassword` constraint plus centralized
  validation messages and patterns.
- **Global exception handling** — consistent, structured API error responses.
- **Layered architecture** — Controller → Service → Repository, with DTOs at
  the boundary.

## Project Structure

```
.
├── backend/    # Spring Boot REST API (Java 21)
├── frontend/   # Angular 19 application
└── wrapper/    # Maven wrapper
```

## Getting Started

### Backend

```bash
cd backend
./mvnw spring-boot:run
```

Requirements: Java 21+, Maven 3.9+, and a running MySQL instance.
Configure the datasource in `backend/src/main/resources/application.properties`.

### Frontend

```bash
cd frontend
npm install
ng serve
```

App runs at http://localhost:4200.

## Author

Rafael Felipe Cordeiro — [GitHub](https://github.com/mozca33)
