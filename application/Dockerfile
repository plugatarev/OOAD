FROM alpine:3.16

ARG version=17.0.5.8.1
ADD /target/PlanningAndDoing-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]