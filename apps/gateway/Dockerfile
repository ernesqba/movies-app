# Use an official Java runtime as the base image
FROM openjdk:17-jdk-slim as builder

# Set the working directory
WORKDIR /app

# Copy the code into the container
COPY . .

# Package the application as an executable JAR
RUN ./mvnw clean package

# Use a minimal image as the final image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the compiled code and the JAR from the builder stage
COPY --from=builder /app/target/*.jar /app/app.jar

# Expose the port that the application runs on
EXPOSE 8090

# Run the application
ENTRYPOINT ["java","-jar","/app/app.jar"]
