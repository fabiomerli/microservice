FROM openjdk:8-jre

# copy application JAR
COPY target/Eureka*.jar /Eureka.jar

EXPOSE 8761

# specify default command
CMD ["/usr/bin/java", "-jar", "/Eureka.jar"]
