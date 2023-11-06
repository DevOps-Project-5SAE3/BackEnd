FROM openjdk:11
EXPOSE 8089
RUN apt-get update && apt-get install -y curl
RUN curl -o DevOps_Project-2.1.jar http://192.168.33.10:8081/#browse/browse:maven-releases:tn%2Fesprit%2FDevOps_Project%2F2.1%2FDevOps_Project-2.1.jar
ADD target/*.jar Dev0ps_Project-2.1.jar

ENTRYPOINT ["java","-jar","/DevOps_Project-2.1.jar"]