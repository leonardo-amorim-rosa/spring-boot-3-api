# Projeto Spring Boot 3 Api

## Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Data
- Spring Validation
- Lombok
- Flyway
- Swagger (Open API)
- MySql

## Subindo MySql local

Desejável que se tenha docker instalado, pois existe um arquivo para subir o mesmo de forma facilitada na aplicação,
o arquivo docker-compose.yml.

Utilize o comando abaixo para subir a instância do mysql local

```
docker-compose up
```

## Para executar em ambiente de desenvolvimento

Como uma aplicação Spring Boot, os procedimentos para executar são padrões.

```
mvn clean spring-boot:run
```

## Para executar em Produção

```
mvn -Dspring.profiles.active=prod -DDATASOURCE_URL=url_do_banco -DDATASOURCE_USERNAME=username
-DDADASOURCE_PASS=password api{versao}.jar
```

## Para gerar imagem nativa (necessário ter a grallvm instalada)

```
mvn -Pnative native:compile
```
