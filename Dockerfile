# Use the specified Maven image with Eclipse Temurin JDK
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build

# Set the working directory
WORKDIR /app

# Copy the project files into the container
COPY . .

# Build the application, skipping tests
RUN mvn clean package -DskipTests

# Use a lightweight JDK image for the runtime
FROM eclipse-temurin:17-alpine

# Copy the built JAR file from the build stage
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
