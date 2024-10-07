# Desafio - Itau

## Technologies
- Spring Boot
- Postgresql
- Docker

## Compilando o projeto

Executar um dos comandos do MAVEN após importar

mvn clean install -DskipTests

mvn clean install 

## Iniciando a API:
Executar o comando para compilar o container:

docker build -t desafio .

Executar o comando para iniciar o container:

docker run -p 8080:8080 desafio


## Exemplo de Utilização

* GET Category:

curl -X 'GET' \
  'http://localhost:8080/desafio/v1/api/category/' \
  -H 'accept: */*'
  
  
* POST Quotation e Calculo:

curl -X 'POST' \
  'http://localhost:8080/desafio/v1/api/quotation/' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "seguro vida individual",
  "categoria": "viagem",
  "preco_base": 2
}'



