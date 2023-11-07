FROM openjdk:11
RUN apt-get update && apt-get install -y curl
RUN curl -o DevOps_Project-2.1.jar "http://192.168.33.10:8081/repository/maven-releases/tn/esprit/DevOps_Project/2.1/DevOps_Project-2.1.jar"
COPY target/DevOps_Project-2.1.jar /DevOps_Project-2.1.jar
ENTRYPOINT ["java","-jar","/DevOps_Project-2.1.jar"]
EXPOSE 8089


