# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-17-alpine AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests=true

# Stage 2: Create the final image
FROM eclipse-temurin:17.0.12_7-jre-alpine
WORKDIR /app
# Set default environment variables (these can be overridden at runtime)
ENV MAIL_USERNAME=default_username
ENV MAIL_PASSWORD=default_password

COPY --from=build /app/target/SpringBoot-Mail-Server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
