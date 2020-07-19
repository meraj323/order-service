FROM node:14-alpine
FROM openjdk:8-jre
ADD target/order-service.RELEASE.jar app.jar
EXPOSE 1111
EXPOSE 2222
EXPOSE 3333
ENTRYPOINT ["java","-jar","/app.jar","orders"]
