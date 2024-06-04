# BookStore

## Description
BookStore is a microservice-based web application built with Java and Kotlin. It uses Spring Boot for the backend, Spring Data JPA for data access, and Spring Security for authentication and authorization. The application is organized into several services, each with its own responsibility, communicating through Eureka service discovery. The services are containerized using Docker for easy deployment and scalability. The application uses PostgreSQL as its database.

## Technologies
- Java, Kotlin
- Gradle
- Eureka
- Postgres
- Docker
- Microservices
- Spring Boot
- Spring Data JPA
- Spring Security

## Installation
Clone the repository: git clone https://github.com/shadow4733/bookstore-microservice.git
Change directory to the project root: cd bookstore-microservice
Run the following command to build the project: ./gradlew clean build

## Running with Docker
1. Build the Docker images: docker-compose build
2. Start the Docker containers: docker-compose up
Note: The docker-compose up command will start all the services defined in the docker-compose.yml file. Each service will be accessible on its own port as defined in the file.

## Eureka Service Discovery
The Eureka service discovery is running on port 8761. You can access the Eureka dashboard by navigating to http://localhost:8761 in your web browser. The dashboard will display all the registered services.

## Usage
After starting the application, you can interact with the services through their respective APIs. Each service runs on its own port and has its own set of endpoints. For example, to interact with the book-service, you would send requests to http://localhost:8084/
