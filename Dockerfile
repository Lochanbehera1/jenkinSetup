FROM openjdk:17
EXPOSE 8080
COPY target/app.jar /usr/app
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","/app.jar"]