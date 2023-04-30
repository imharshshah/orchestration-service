FROM openjdk:8
EXPOSE 8080
ADD target/orchestration_service-github_action.jar orchestration_service-github_action.jar
ENTRYPOINT ["java","-jar","/orchestration_service-github_action.jar"]