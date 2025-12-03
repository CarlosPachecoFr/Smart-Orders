# ===========================
# Stage 1: compilación con Maven
# ===========================
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar todo el proyecto multimódulo
COPY . /app

# Build solo microservice-order y sus dependencias
RUN mvn clean package -DskipTests -pl microservice-order -am

# ===========================
# Stage 2: runtime ligero
# ===========================
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copiar el JAR compilado
COPY --from=build /app/microservice-order/target/*.jar app.jar

EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]