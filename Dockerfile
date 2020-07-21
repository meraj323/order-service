#
# Build stage
#
FROM maven:3.6.0-jdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#

#FROM openjdk:8-jdk-alpine
FROM openjdk:8-jre-slim
COPY --from=build /home/app/target/order-service-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]

#ADD target/order-service-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 1111
#EXPOSE 2222
#EXPOSE 3333
#ENTRYPOINT ["java","-jar","/app.jar"]

#FROM java:8-jdk-alpine
#COPY ./target/order-service-0.0.1-SNAPSHOT.jar /usr/app/
#WORKDIR /usr/app
#RUN bat -c 'touch order-service-0.0.1-SNAPSHOT.jar'
#ENTRYPOINT ["java","-jar","order-service-0.0.1-SNAPSHOT.jar"]
