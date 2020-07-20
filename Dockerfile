FROM node:14-alpine
FROM openjdk:8-jre
ADD target/order-service.RELEASE.jar app.jar
EXPOSE 1111
EXPOSE 2222
EXPOSE 3333
ENTRYPOINT ["java","-jar","/app.jar","orders"]

#FROM java:8-jdk-alpine
#COPY ./target/order-service-0.0.1-SNAPSHOT.jar /usr/app/
#WORKDIR /usr/app
#RUN sh -c 'touch demo-docker-0.0.1-SNAPSHOT.jar'
#ENTRYPOINT ["java","-jar","demo-docker-0.0.1-SNAPSHOT.jar"]
