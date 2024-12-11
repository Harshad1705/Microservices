# base image
FROM eclipse-temurin:21
# defining meta data
LABEL maintainer="hp85247@gmail.com"
# defining working directory
WORKDIR /app
# copy source file into destination
COPY target/springboot-docker-demo-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar
# start the jar file 
ENTRYPOINT [ "java" , "-jar" , "springboot-docker-demo.jar" ]