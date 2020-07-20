FROM node:14-alpine
FROM openjdk:nanoserver
ADD ./target/order-service-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 1111
#EXPOSE 2222
EXPOSE 3333
ENTRYPOINT ["java","-jar","/app.jar"]

#FROM java:8-jdk-alpine
#COPY ./target/order-service-0.0.1-SNAPSHOT.jar /usr/app/
#WORKDIR /usr/app
#RUN bat -c 'touch order-service-0.0.1-SNAPSHOT.jar'
#ENTRYPOINT ["java","-jar","order-service-0.0.1-SNAPSHOT.jar"]
