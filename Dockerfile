# Stage 1: Build the application
#FROM maven:3.8.4-openjdk-21 AS build
#RUN mvn clean package -DskipTests


FROM ubuntu:latest
WORKDIR /app

# install required packages
RUN apt-get update &&   apt-get install -y nginx openjdk-21-jre   wget && apt-get clean

RUN apt-get install apt-transport-https

RUN apt-get update && apt-get install -y gnupg2
RUN apt-get update && apt-get install -y gnupg

# install logshash
RUN wget -qO - https://artifacts.elastic.co/GPG-KEY-elasticsearch |   gpg --dearmor -o /usr/share/keyrings/elastic-keyring.gpg && \
    echo "deb [signed-by=/usr/share/keyrings/elastic-keyring.gpg] https://artifacts.elastic.co/packages/8.x/apt stable main" |   tee -a /etc/apt/sources.list.d/elastic-8.x.list &&\
      apt-get update &&   apt-get install logstash && \
    apt-get clean


# Install Grafana
RUN wget -q -O - https://packages.grafana.com/gpg.key | gpg --dearmor -o /usr/share/keyrings/grafana-keyring.gpg && \
    echo "deb [signed-by=/usr/share/keyrings/grafana-keyring.gpg] https://packages.grafana.com/oss/deb stable main" | tee -a /etc/apt/sources.list.d/grafana.list && \
    apt-get update && \
    apt-get install -y grafana && \
    apt-get clean



# Copyright configuration
COPY  /target/shorter-0.0.1-SNAPSHOT.jar /app/shorter.jar
COPY  /nginx/nginx.conf  /etc/nginx/nginx.conf
COPY  logs/logstash/logstash.conf /etc/logstash/conf.d/logstash.conf
COPY  logs/logstash/pipelines.yml  /usr/share/logstash/config/pipelines.yml
COPY  visualization/grafana/datasources/datasource-pg.yml /etc/grafana/provisioning/datasources/
COPY  visualization/grafana/dashboards/dashboards-pg.json /etc/grafana/provisioning/dashboards/
COPY  visualization/grafana/provisioning/dashboards.yml /etc/grafana/provisioning/dashboards/


EXPOSE 1110 80 3000

CMD   java -jar /app/shorter.jar && \
    nginx -g "daemon off;" && \
    sleep 60 && service dbus restart && cd /usr/share/logstash/bin && ./logstash -f /etc/logstash/conf.d/logstash.conf && \
    service grafana-server start


