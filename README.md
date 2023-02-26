# Movies App
This is a sample movies app built with Java, Spring and MySQL. It includes two microservices for managing movies and actors and another one for managing users with critics. The frontend service allows users to browse for movies, critics, actors and users and also includes a feature to add reviews. The app is also configured to use spring gateway as a api gateway for the back services (movies-api and security-api) and an eureka server.

## Dependencies
- Docker
- Docker Compose

## Running the App
1. Clone the repository: git clone https://github.com/ernesqba/movies-app.git
2. Navigate to the project root: cd movies-app
3. Start the app: docker-compose up
4. Open the app in your browser: http://localhost:4000


## Services
### Frontend Service
The frontend service is responsible for serving the web interface of the movies app. It is built with Spring and Java and runs on port 4000. It communicates with the other microservices through HTTP requests. The following environment variables are available for configuring the service:

* PORT: the port the service runs on (default: 4000)
* MOVIES_URL: the URL of the movies service (default: http://gateway:8090/api/movies)
* SECURITY_URL: the URL of the security service (default: http://gateway:8090/api/security)

### Security Service
The security service is responsible for managing user accounts in the movies app and also the critics. It is built with Spring and Java and runs on port 3001. It communicates with the MySQL database for storing user data. The following environment variables are available for configuring the service:

* PORT: the port the service runs on (default: 3001)
* DB_CONNECTION: the URL conection of the MySQL database (default: jdbc:mysql://db-security:3306/security_db?useSSL=false&serverTimezone=Europe/Madrid&allowPublicKeyRetrieval=true)
* DB_USER: the MySQL database username (default: root)
* DB_PASSWORD: the MySQL database password (default: root)
* EUREKA_URL: the URL of the eureka service (default: http://eureka-server:8761/eureka)

### Movies Service
The movies service is responsible for managing movies and actors in the movies app. It is built with Spring and Java and runs on port 3000. It communicates with the MySQL database for storing movies data. The following environment variables are available for configuring the service:

* PORT: the port the service runs on (default: 3000)
* DB_CONNECTION: the URL conection of the MySQL database (default: jdbc:mysql://db-movies:3306/security_db?useSSL=false&serverTimezone=Europe/Madrid&allowPublicKeyRetrieval=true)
* DB_USER: the MySQL database username (default: root)
* DB_PASSWORD: the MySQL database password (default: root)
* EUREKA_URL: the URL of the eureka service (default: http://eureka-server:8761/eureka)

### Database Service
In this app we are using two instances of MySQL, one to work with the movies service and another one to work with the security service. They run on port 3306 and are exposed on port 3306 and 3307 for accessing the database from outside the Docker

## Conclusion
The movies app is a sample application that showcases how to build a multi-service Spring-Java application with a MySQL database. With Docker Compose, it is easy to start up and manage the app, along with other useful tools like Eureka Server and Api Gateway.