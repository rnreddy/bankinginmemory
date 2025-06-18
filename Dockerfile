#Start from a lightweight OpenJDK runtime image
FROM amazoncorretto:17
ENV JAVA_OPTS=""
WORKDIR /app
COPY target/bankinginmemory.jar bankinginmemory.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bankinginmemory.jar"]
