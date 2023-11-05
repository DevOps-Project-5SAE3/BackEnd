FROM openjdk:11
EXPOSE 8089
RUN apt-get update && apt-get install -y curl
RUN curl -o DevOps_Project-2.1.jar http://192.168.1.175:8081/repository/maven-public/tn/esprit/DevOps_Project/2.1/DevOps_Project-2.1.jar
CMD ["java","-jar","/DevOps_Project-2.1.jar"]
