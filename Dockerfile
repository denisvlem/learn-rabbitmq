FROM fabric8/java-alpine-openjdk11-jre:latest

ADD target/*jar /deployments
EXPOSE 8080

ENV LANG=en_GB.UTF-8
RUN export JAVA_APP_JAR=/deployments/$(ls /deployments/*jar)