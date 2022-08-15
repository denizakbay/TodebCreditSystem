FROM openjdk:8-jdk-alpine

EXPOSE 8080
ADD target/todeb-credit-system-0.0.1-SNAPSHOT.jar todeb-credit-system.jar

ENTRYPOINT ["java","-jar","todeb-credit-system.jar"]