FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD /target/demo-service-0.0.1-SNAPSHOT.jar demo-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo-service.jar"]