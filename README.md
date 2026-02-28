## Car Rental REST API

A simple **RESTful API** for managing a car rental service, built with **Spring Boot**.  
This project provides endpoints to create, read, update and delete cars and bookings, and includes centralized exception handling for clean, consistent JSON error responses.

### Features

- Basic CRUD operations for cars and bookings  
- Booking management with start/end dates  
- Global exception handling using `@ControllerAdvice` for:
  - Business/validation errors (`IllegalArgumentException`)
  - Bean validation errors (`MethodArgumentNotValidException`)
- Standardized API error responses in JSON  

### Tech Stack

- Java 25
- Spring Boot 3.5.10
- Spring Web
- Spring Data JPA
- Spring Validation
- MySQL 8.0.44
- Maven
