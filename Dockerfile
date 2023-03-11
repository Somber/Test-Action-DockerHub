FROM maven:3.3-jdk-8 AS build-env

ARG JAVA_ENV
ENV java_env=$JAVA_ENV

WORKDIR /usr/src/mymaven
COPY .  ./
RUN mvn clean install

FROM openjdk:8-alpine
WORKDIR /usr/share/
COPY  --from=build-env /usr/src/mymaven/target/apitest5*.jar ./app.jar
COPY  --from=build-env /usr/src/mymaven/target/config/* ./config

ARG JAVA_ENV
ENV java_env=$JAVA_ENV

CMD /usr/bin/java -jar /usr/share/app.jar
