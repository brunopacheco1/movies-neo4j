FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 3100

ADD ./target/movies-neo4j.jar app.jar

RUN sh -c 'touch /app.jar'

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]