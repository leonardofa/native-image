FROM ghcr.io/graalvm/graalvm-ce:latest AS build

WORKDIR /workspace
COPY . .

RUN gu install native-image
RUN ./mvnw -Pnative native:compile -DskipTests

FROM ubuntu:22.04 AS final

RUN apt-get update && apt-get install -y libstdc++6 && apt-get clean

# Configurar o diretório de trabalho
WORKDIR /app

# Copiar o executável gerado na fase anterior
COPY --from=build /workspace/target/app .

# Expor a porta usada pelo aplicativo
EXPOSE 8080

# Comando padrão para rodar o binário
CMD ["./app"]
