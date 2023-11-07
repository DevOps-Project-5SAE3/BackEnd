FROM openjdk:11
EXPOSE 8089


COPY target/DevOps_Project-2.1.jar /DevOps_Project-2.1.jar

CMD ["java" , "-jar", "/DevOps_Project-2.1.jar"]