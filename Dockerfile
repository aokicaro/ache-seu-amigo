# Usa uma imagem do OpenJDK 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado pelo Maven para dentro do container
COPY target/*.jar app.jar

# Expondo a porta da aplicação
EXPOSE 8080

# Comando para rodar o backend
CMD ["java", "-jar", "app.jar"]
