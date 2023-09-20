FROM openjdk:latest
COPY target/ufc-back-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9696
ADD uploads uploads
ENTRYPOINT ["java", "-jar", "/app.jar"]