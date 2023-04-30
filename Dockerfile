FROM openjdk:8
EXPOSE 8080
COPY Combined_schema.json /app/
RUN ln -s /app/Combined_schema.json /Combined_schema.json
COPY payments_schema.json /app/
RUN ln -s /app/payments_schema.json /payments_schema.json
COPY subscription_schema.json /app/
RUN ln -s /app/subscription_schema.json /subscription_schema.json
ADD target/orchestration_service-github_action.jar orchestration_service-github_action.jar
ENTRYPOINT ["java","-jar","/orchestration_service-github_action.jar"]