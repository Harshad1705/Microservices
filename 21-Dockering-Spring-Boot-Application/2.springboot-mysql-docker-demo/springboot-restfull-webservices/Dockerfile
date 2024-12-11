# base image 
FROM eclipse-temurin:17 
# metadata
LABEL maintainer="hp85247@gmail.com"
# create working directory
WORKDIR /app
# copy from source to destination
COPY target/springboot-restfull-webservices-0.0.1-SNAPSHOT.jar /app/springboot-restfull-webservices.jar
# define entry point instruction  
ENTRYPOINT [ "java" , "-jar" , "springboot-restfull-webservices.jar" ]