FROM openjdk:17-jdk-alpine

EXPOSE 8081

ADD target/SpringBootDemo-0.0.1-SNAPSHOT.jar inttest.jar

CMD ["java", "-jar", "inttest.jar"]