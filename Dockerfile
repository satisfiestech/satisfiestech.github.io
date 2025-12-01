# Step 1: Use official JDK image
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Step 2: Set app directory
WORKDIR /app
COPY pom.xml .
# Step 3: Copy Maven/Gradle build output (JAR)
COPY target/*.jar app.jar
RUN mvn clean package -DskipTests
# Step 4: Expose Spring Boot default port
ENV PORT=9090
EXPOSE 9090

# Step 5: Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
