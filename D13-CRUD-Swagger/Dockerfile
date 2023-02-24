FROM maven:3.8.3-openjdk-17-slim AS maven

WORKDIR /usr/src/app
#COPY . /usr/src/app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ src/
RUN mvn package -DskipTests

FROM openjdk:17-jdk-slim
ARG JAR_FILE=D13-CRUD-Swagger-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app/

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app

EXPOSE 5000

ENTRYPOINT ["java", "-jar", "D13-CRUD-Swagger-0.0.1-SNAPSHOT.jar"]

