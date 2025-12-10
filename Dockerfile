# ---------- Build stage ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# copy only what's needed for dependency resolution first (cache)
COPY pom.xml mvnw ./
COPY .mvn .mvn

# make wrapper executable inside the image, then use it
RUN chmod +x mvnw \
 && ./mvnw -B -DskipTests dependency:go-offline

# copy sources and build the jar
COPY src src
RUN ./mvnw -B -DskipTests clean package

# ---------- Run stage ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# copy the built jar (your pom: artifactId bulkbuy version 0.0.1-SNAPSHOT)
COPY --from=build /app/target/bulkbuy-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8080
EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT} -jar /app/app.jar"]
