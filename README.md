## Car Rental REST API + Tests

A simple **RESTful API** for managing a car rental service, built with **Spring Boot**.  
This repository also includes **automated API tests** to validate the main endpoints and common error scenarios.

### API Features

- Basic CRUD operations for cars and bookings
- Booking management with start/end dates
- Global exception handling using `@ControllerAdvice` for:
  - Business/validation errors (`IllegalArgumentException`)
  - Bean validation errors (`MethodArgumentNotValidException`)
- Standardized JSON error responses

### Tests

- API-level tests for core flows (cars, bookings) and validation/error handling
- Designed to be runnable locally and in CI

### Tech Stack

- Java 25
- Spring Boot 3.5.10
- Spring Web
- Spring Data JPA
- Spring Validation
- MySQL 8.0.44
- Maven
