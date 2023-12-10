# Stage 1: Build the application
FROM maven:3.8.6 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

# Stage 2: Run the application
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/VideoCall-0.0.1-SNAPSHOT.jar ./videocall-app.jar
EXPOSE 8080
CMD ["java", "-jar", "videocall-app.jar"]

# Commands
# docker buildx build --platform linux/amd64 -t sainishivam493/videocall-app:1.0 .
# docker push sainishivam493/videocall-app:1.0