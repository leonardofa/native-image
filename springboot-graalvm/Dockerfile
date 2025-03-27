FROM --platform=linux/arm64 ghcr.io/graalvm/native-image:ol9-java17-22.3.3 AS build

WORKDIR /workspace

COPY pom.xml mvnw ./
COPY .mvn ./.mvn

RUN mkdir -p src/main/java
RUN ./mvnw dependency:go-offline -B

COPY src ./src

RUN ./mvnw clean -Pnative native:compile -DskipTests

FROM --platform=linux/arm64 container-registry.oracle.com/os/oraclelinux:9-slim AS final

WORKDIR /workspace

COPY --from=build /workspace/app .

EXPOSE 8080

CMD ["./app"]
