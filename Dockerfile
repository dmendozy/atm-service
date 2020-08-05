FROM openjdk:8
ADD target/atm-service.jar atm-service.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","atm-service.jar"]