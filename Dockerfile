FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/blockchain-java.jar app.jar
EXPOSE 8080 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
