# Stage 1: compilación con Maven
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copia sólo los ficheros esenciales y descarga dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia el resto del código y compila
COPY src ./src
RUN mvn clean package -DskipTests -B

# Stage 2: runtime ligero
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# (Opcional) instala herramientas que necesites en tiempo de ejecución
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Copia el JAR ya compilado desde el primer stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]