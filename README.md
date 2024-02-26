# Parking System REST API

+ This is a REST API for a Parking System, allowing users to register vehicles and their owners for use the parking slot.

### Technologies Used:

+ Java Spring Framework
  + Spring Web
  + Spring Boot
  + Spring Data JPA
+ Lombok
+ MySQL
+ H2 Database(for development)
+ Spring Boot Starter Validation

### Features

+ Register new vehicles and their owners
+ Retrieve information about registered vehicles and owners
+ Update existing vehicle and owner information
+ Delete registered vehicles or owners

### API Endpoints

+ `GET /vehicles`: Get all registered vehicles details
+ `GET /vehicles/{id}`: Get a vehicle details by id
+ `POST /vehicles`: Register a new vehicle
+ `PUT /vehicles/{id}` Update vehicle details
+ `DELETE /vehicles/{id}` Delete a registered vehicle 

### Getting Started

+ To run the project locally, follow these steps:

  1. Clone the repository to your local machine:

  ```Shell
    git clone https://github.com/your-username/parking-system-api.git
  ```

  2. Navigate to the project directory:
  
  ```Shell
    cd parking-system-api
  ```

  3. Ensure you have **Java** and **Maven** installed on your machine.

  4. Configure the database settings in the `application.properties` file:

  ```Shell
    spring.datasource.url=jdbc:mysql://localhost:3306/parking_db
    spring.datasource.username=root
    spring.datasource.password=password
  ```

  5. Run the application using Maven:
 
  ```Shell
    mvn spring-boot:run
  ```

  6. The API should now be accessible at http://localhost:8080.
