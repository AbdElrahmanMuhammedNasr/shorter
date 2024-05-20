#!/bin/bash

# Start the Java application
java -jar /app/shorter.jar &

# Start Nginx
nginx -g "daemon off;" &

# Sleep to allow services to start
sleep 10

# Restart dbus service
service dbus restart

# Start Logstash
cd /usr/share/logstash/bin && ./logstash -f /etc/logstash/conf.d/logstash.conf &

# Start Grafana
service grafana-server start

# Prevent the script from exiting immediately
tail -f /dev/null
