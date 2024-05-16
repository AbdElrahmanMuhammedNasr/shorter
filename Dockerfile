# Stage 1: Build the application
#FROM maven:3.8.4-openjdk-21 AS build
#WORKDIR /app
#COPY . /app
#RUN #mvn clean package -DskipTests


# Install Nginx
FROM alpine:latest
WORKDIR /app
RUN apk update && apk add nginx openjdk21-jre
COPY  /target/shorter-0.0.1-SNAPSHOT.jar /app/shorter.jar

EXPOSE 1110 80

COPY  /nginx.conf  /etc/nginx/nginx.conf

CMD java -jar shorter.jar  && /usr/sbin/nginx -g "daemon off;"

