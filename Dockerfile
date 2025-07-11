# Instalando uma imagem do JDK 21
FROM openjdk:21

# crIANDO UMA PASTA ONDE O DOCKER IRÁ COPIAR OS ARQUIVOS DO PROJETO
WORKDIR /app

# Copiando todos os arquivos do projeto para dentro desta pasta 
COPY . /app

#Comqando para fazer o DEPLOY do prjeto
RUN ./mvnw -B clean package -DskipTests

#Porta em que o projeto será executado
EXPOSE 8081

# Script para executar o projeto
CMD ["java", "-jar", "target/apiPedidos-0.0.1-SNAPSHOT.jar"]