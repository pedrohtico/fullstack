# Use an official OpenJDK runtime as the base image
FROM openjdk:21
# Set the working directory inside the container
WORKDIR /app

# Copy the Quarkus JAR file into the container
COPY authorization-api/target/quarkus-app/lib /app/lib/
COPY authorization-api/target/quarkus-app/app /app/app/
COPY authorization-api/target/quarkus-app/quarkus/ /app/quarkus/
COPY authorization-api/target/quarkus-app/quarkus-run.jar /app/quarkus-run.jar

# Expose the port that Quarkus will run on
EXPOSE 8080

# Command to run the Quarkus application
ENTRYPOINT ["java", "-jar", "/app/quarkus-run.jar"]