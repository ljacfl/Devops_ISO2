FROM openjdk:21
COPY target/insurance-policies-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8050
ENTRYPOINT ["java", "-jar", "/app.jar"]