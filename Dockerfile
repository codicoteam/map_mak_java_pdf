
# Step 1: Use an official Maven image to build the project
FROM maven:3.9.1-eclipse-temurin-17 as build

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the pom.xml and install dependencies
COPY pom.xml .

# Step 4: Download the dependencies (this will cache them if they haven't changed)
RUN mvn dependency:go-offline

# Step 5: Copy the rest of the application source code
COPY src ./src

# Step 6: Package the Spring Boot application (it will be built as a jar)
RUN mvn clean package -DskipTests

# Step 7: Use an official OpenJDK image to run the application
FROM eclipse-temurin:17-jre-alpine

# Step 8: Set the working directory inside the container
WORKDIR /app

# Step 9: Copy the jar from the build stage into the image
COPY --from=build /app/target/pdf-maker-0.0.1-SNAPSHOT.jar pdf-maker.jar

# Step 10: Expose the port the app will run on
EXPOSE 8082

# Step 11: Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/pdf-maker.jar"]
