FROM openjdk:8
EXPOSE 8089
ADD target/DevOps_Project-2.1.jar docker-sts.jar
ENTRYPOINT ["java","-jar","docker-sts.jar"]