FROM openjdk:21
COPY target/payment-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9030
ENTRYPOINT ["java", "-jar", "/app.jar"]