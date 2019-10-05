# MiniCms
MiniCms api utilizando o banco de dados in memory H2.

As operações podem ser testadas via collection do postman que se encontra na pasta docs/


## Requisitos da entrega

Operações expostas como endpoints REST para:

* Cadastrar cidade
* Cadastrar cliente
* Consultar cidade pelo nome
* Consultar cidade pelo estado
* Consultar cliente pelo nome
* Consultar cliente pelo Id
* Remover cliente
* Alterar o nome do cliente

Considere o cadastro com dados básicos: 
* Cidades: nome e estado
* Cliente: nome completo, sexo, data de nascimento, idade e cidade onde mora.

## Requisitos

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

### Build an executable JAR
Build a single executable JAR file that contains all the necessary dependencies, classes, and resources with:
```
mvn clean package
```
Then you can run the JAR file with:
```
java -jar target/*.jar
```