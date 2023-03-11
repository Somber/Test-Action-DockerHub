FROM maven:3.3-jdk-8 AS build-env
WORKDIR /usr/src/mymaven
COPY .  ./
RUN mvn clean install

FROM openjdk:8-alpine
WORKDIR /usr/share/
COPY  --from=build-env /usr/src/mymaven/target/apitest5*.jar ./app.jar

ARG ENTORNO
ENV entorno=$ENTORNO

CMD /usr/bin/java -jar $entorno /usr/share/app.jar
