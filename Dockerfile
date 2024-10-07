FROM openjdk:19
EXPOSE 8080
ADD target/desafio.jar desafio.jar
ENTRYPOINT ["java", "-jar", "desafio.jar"]