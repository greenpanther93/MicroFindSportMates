#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#EXPOSE 8081
#ENTRYPOINT ["java","-jar","/app.jar"]
FROM tomcat:7.0
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} /usr/local/tomcat/webapps/
EXPOSE 8080