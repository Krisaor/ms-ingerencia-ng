#Build jar file
FROM gradle AS build
WORKDIR /home/app
COPY . /home/app
RUN gradle build -x test

#Create an Java Image
FROM openjdk
EXPOSE 8080
COPY --from=build /home/app/build/libs/ms-ingerencia-ng-0.0.1-SNAPSHOT.jar ms-ingerencia-ng-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh", "-c", "java -jar /ms-ingerencia-ng-0.0.1-SNAPSHOT.jar"]