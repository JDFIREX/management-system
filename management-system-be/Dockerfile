FROM maven:3.9.5-amazoncorretto-21 AS build

WORKDIR /usr/src/app

COPY ./src ./src
COPY ./pom.xml .

RUN mvn clean package

FROM amazoncorretto:21

WORKDIR /usr/src/app

COPY --from=build /usr/src/app/target/management-system-be.jar .

CMD ["java", "-jar", "management-system-be.jar"]
