FROM maven:3.8.4-openjdk-17 AS builder

# Crie um diretório de trabalho temporário
WORKDIR /build

# Copie o arquivo pom.xml primeiro para aproveitar o cache do Docker
COPY app/pom.xml .

# Copie o diretório src/ do seu projeto
COPY app/src/ ./src/

# Execute o Maven no diretório de construção
RUN mvn clean package -DskipTests

# Agora configure o diretório de trabalho final
WORKDIR /app

# Copie os artefatos do Maven para o diretório /app
RUN cp /build/target/*.jar /app/

FROM openjdk:17

ENV APP_NAME PetBackend

COPY --from=builder /app/${APP_NAME}-0.0.1-SNAPSHOT.jar /app/${APP_NAME}.jar

WORKDIR /app

CMD java -jar ${APP_NAME}.jar

EXPOSE 8080
