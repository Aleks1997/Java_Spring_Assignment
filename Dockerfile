# Start with the official OpenJDK 17 image
FROM openjdk:17-jdk-slim

# Install MySQL client
RUN apt-get update && \
    apt-get install -y default-mysql-client

# Set the working directory to /app
WORKDIR /app

# Copy the Spring Boot application to the container
COPY target/JavaSpringComtrade360-0.0.1-SNAPSHOT.jar /app/JavaSpringComtrade360-0.0.1-SNAPSHOT.jar

# Copy the application.properties file to the container
COPY src/main/resources/application.properties /app/application.properties

# Expose the port the application will run on
EXPOSE 8080

# Set the environment variables for the database connection
ENV SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/helloworld \
    SPRING_DATASOURCE_USERNAME=root \
    SPRING_DATASOURCE_PASSWORD=pass

# Wait for MySQL to start up before running the Spring Boot application
CMD ["sh", "-c", "while ! nc -z localhost:3306; do sleep 1; done; java -jar JavaSpringComtrade360-0.0.1-SNAPSHOT.jar"]