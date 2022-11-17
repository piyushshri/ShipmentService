FROM openjdk:8
EXPOSE 8090
ADD target/ShipmentService-0.0.1-SNAPSHOT.jar ShipmentService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ShipmentService-0.0.1-SNAPSHOT.jar"]