FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD /target/gestion-modelo-service.app-0.0.1-SNAPSHOT.jar gestion-modelo-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/gestion-modelo-service.jar"]