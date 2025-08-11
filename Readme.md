# Task Tracking App

This is a simple task tracking application built with Spring Boot.

## Configuration

The application uses a PostgreSQL database for production. To run the application, you need to set the following environment variables:

- `JDBC_DATABASE_USERNAME`: The username for the PostgreSQL database.
- `JDBC_DATABASE_PASSWORD`: The password for the PostgreSQL database.

Example:
```bash
export JDBC_DATABASE_USERNAME=your_username
export JDBC_DATABASE_PASSWORD=your_password
```

## Running the application
Once the environment variables are set, you can run the application using Maven:
```bash
./mvnw spring-boot:run
```

## Testing
The application uses an H2 in-memory database for testing, so no special configuration is required to run the tests.
```bash
./mvnw test
```
