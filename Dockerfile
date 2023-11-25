FROM maven:3.8.4-openjdk-17 AS builder

WORKDIR /app

RUN mvn dependency:go-offline

RUN mvn clean install -DskipTests

FROM openjdk:17

ENV APP_NAME PetBackend

COPY /app/target/${APP_NAME}-0.0.1-SNAPSHOT.jar  /app/${APP_NAME}.jar

WORKDIR /app

CMD java -jar ${APP_NAME}.jar

EXPOSE 8080