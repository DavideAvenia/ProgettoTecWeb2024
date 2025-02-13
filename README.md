# ProgettoTecWeb2024

This repository contains the source code for the TecWeb 2024 project. The project is divided into two main parts:
- **Backend:** Implemented in Java 17 using Spring Boot. You can find the source code in the `Innervision` directory.
- **Frontend:** Implemented in Angular 17. The source code is available in the `InnervisionFE` directory.

## Installation and Startup

### System Requirements
- Java Development Kit (JDK) 17
- Node.js and npm (for the Angular frontend)
- Docker (optional, for running with Docker Compose)

### Backend (Spring Boot)

1. **Clone the repository:**

```bash
git clone https://github.com/AveniaD/ProgettoTecWeb2024.git
cd ProgettoTecWeb2024/Innervision
```

3. **Compile and run the backend:**

```bash
./mvnw spring-boot:run`
```

This command compiles the source code and starts the Spring Boot server. Make sure you have correctly configured the `application.properties` file for database connection and other specific configurations.

3. **Accessing the backend:**
Once started, the backend will be accessible at `http://localhost:8080`.

### Frontend (Angular)

1. **Install dependencies:**

```bash
cd ../InnervisionFE
npm install
```

2. **Start the development server for the frontend:**

The `ng serve` command starts the Angular development server. Access the frontend UI through the browser at `http://localhost:4200`.

### Running with Docker Compose

If you prefer using Docker to manage the development environment, you can use Docker Compose to start both the backend and frontend together.

#### `docker-compose.yml`

Create a file named `docker-compose.yml` in the root of your project with the following content:

```yaml
version: '3.8'

services:
mysql-db:
 image: mysql:5.7.24
 environment:
   MYSQL_ROOT_PASSWORD: my-secret-pw
   MYSQL_DATABASE: progettotecweb
 networks:
   - mynetwork

innervision-app:
 build:
   context: ./Innervision
   dockerfile: Dockerfile
 ports:
   - "8080:8080"
 environment:
   SPRING_DATASOURCE_URL: jdbc:mysql://mysql-db:3306/progettotecweb
   SPRING_DATASOURCE_USERNAME: root
   SPRING_DATASOURCE_PASSWORD: 
 depends_on:
   - mysql-db
 networks:
   - mynetwork

innervision-fe:
 build:
   context: ./InnervisionFE
   dockerfile: Dockerfile
 ports:
   - "4200:4200"
 networks:
   - mynetwork

networks:
mynetwork:
```

# Accessing the Application
- Once both the backend and frontend are started with Docker Compose, access the application through the browser at http://localhost:4200.
  
# Contributing
If you wish to contribute to this project, you can fork the repository, make necessary changes, and submit a pull request. Please make sure to clearly describe the changes made and thoroughly test them before submitting the pull request.

This README provides a basic overview of how to install and start the project on a Linux environment using the specified technologies, including using Docker Compose for containerized deployment. Adjust the configurations and commands according to your specific system requirements and setup.

# IDE and application 
For the development of this application we used IntellijIdea for the development of the Backend, VSCode for the development of the Frontend and Laragon Portable for the support of a MySql server version 5.7.24.

