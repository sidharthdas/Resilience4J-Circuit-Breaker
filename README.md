
# Resilience4J-Circuit-Breaker


#Docker Configuration
Add Dockerfile
```
FROM openjdk:17-jdk-alpine
EXPOSE 8080
ADD target/user-service-docker.jar user-service-docker.jar 
ENTRYPOINT ["java","-jar", "/user-service-docker.jar"]

```

Then go to the folder and open terminal and run below commands.

1) docker ps
2) docker images
3) docker build -t user-service-docker.jar .
4) docker run -d -p 9000:8012 user-service-docker.jar

Some more commands:
1) docker stop <container-id>
2) docker start <container-id>
3) docker log <container-id>

Push created docker image to docker hub
1) Create a account in docker hub
2) In terminal run below command
3) docker login
4) once loggedin, we have to create a tag
5) docker tag <image-name> <username>/<image-name>
6) docker push <username>/<image-name>
