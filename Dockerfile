FROM openjdk:17

COPY target/SpringBoot_Docker_Application.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "SpringBoot_Docker_Application.jar"]
