# Etapa de compilación
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml ./
RUN mvn dependency:go-offline

COPY src /app/src
RUN mvn clean package -DskipTests
RUN ls -la /app/target

# Etapa de ejecución
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Cambia el nombre del JAR por el real de tu proyecto
COPY --from=build /app/target/formularioPersonaBackend-0.0.1-SNAPSHOT.jar /app/formularioPersonaBackend.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/formularioPersonaBackend.jar"]