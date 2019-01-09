FROM openjdk:8-jre

# copy application JAR
COPY target/ForexControllerMicroService*.jar /ForexControllerMicroService.jar

EXPOSE 80

# specify default command
CMD ["/usr/bin/java", "-Dserver.port=80", "-jar", "/ForexControllerMicroService.jar"]
