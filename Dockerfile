FROM openjdk:8
COPY target/Candidate-0.0.1-SNAPSHOT.jar  Candidate.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/Candidate.jar"]
