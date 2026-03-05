# -------- Stage 1: Build the application --------
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy project files
COPY . .

# Build the jar
RUN mvn clean package -DskipTests


# -------- Stage 2: Run the application --------
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy jar from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]