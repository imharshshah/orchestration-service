FROM openjdk:8
EXPOSE 8080
COPY Combined_schema.json /app/
COPY payments_schema.json /app/
COPY subscription_schema.json /app/
ADD target/orchestration_service-github_action.jar orchestration_service-github_action.jar
ENTRYPOINT ["java","-jar","/orchestration_service-github_action.jar"]