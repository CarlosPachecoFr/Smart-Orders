# ===========================
# Stage 1: compilación con Maven
# ===========================
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar todo el proyecto multimódulo
COPY . /app

# Build solo microservice-product y sus dependencias
RUN mvn clean package -DskipTests -pl microservice-product -am

# ===========================
# Stage 2: runtime ligero
# ===========================
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copiar el JAR compilado desde el stage de build
COPY --from=build /app/microservice-product/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]