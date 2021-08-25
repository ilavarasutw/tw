FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} bookshop.jar
RUN echo "Hello world"
ENTRYPOINT ["java","-Xmx512m","-jar","bookshop.jar"]