#
# Build stage
#
FROM maven:3.8.5-openjdk-17 as build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/spring-demo-0.0.1-SNAPSHOT.jar spring-demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-demo.jar"]