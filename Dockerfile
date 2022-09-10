FROM gradle:jdk11 as gradleimage
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build


FROM openjdk:11-jre-slim
COPY --from=gradleimage /home/gradle/source/build/libs/ec2-hello-page-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]