FROM openjdk:17-jdk-alpine
COPY target/backendchallenge.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]