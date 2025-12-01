# Step 1: Use official JDK image
FROM eclipse-temurin:21-jdk-alpine

# Step 2: Set app directory
WORKDIR /app

# Step 3: Copy Maven/Gradle build output (JAR)
COPY target/*.jar app.jar

# Step 4: Expose Spring Boot default port
EXPOSE 9090

# Step 5: Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
