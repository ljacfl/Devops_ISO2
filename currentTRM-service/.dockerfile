FROM openjdk:21
COPY target/currentTRM-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/app.jar"]