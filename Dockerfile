# Build stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /build
COPY . .  # Copy all files into the build container
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jdk-slim
WORKDIR /app
COPY --from=build /build/target/marriagehall-0.0.1-SNAPSHOT.jar 
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/marriagehall-0.0.1-SNAPSHOT.jar"]
