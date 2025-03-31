FROM ghcr.io/graalvm/native-image:ol9-java17-22.3.3 AS build

WORKDIR /workspace

COPY .mvn ./.mvn
COPY pom.xml mvnw ./

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

RUN mkdir -p src/main/java
COPY src ./src

RUN ./mvnw clean -Pnative native:compile -DskipTests

FROM container-registry.oracle.com/os/oraclelinux:9-slim AS final

ARG APP_PROFILE=h2
ENV SPRING_PROFILES_ACTIVE=${APP_PROFILE}
ENV DB_HOST=jdbc:h2:mem:testdb

WORKDIR /workspace

COPY --from=build /workspace/app .

EXPOSE 8080

CMD ["./app"]
