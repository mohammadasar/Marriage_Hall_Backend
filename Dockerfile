# Build stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /build
# Copy the contents of the `backend_projects/marriagehall/` folder into the build container
COPY backend_projects/marriagehall/ . 
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jdk-slim
WORKDIR /app
# Copy the JAR from the build container
COPY --from=build /build/target/marriagehall-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
