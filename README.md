## Description
API REST microservice of a calculator, POC version, only additions and subtractions of two operators.

Two endpoints
  - POST /operation/addition for additions
  - POST /operation/substraction for substractions 
  
The operations are performed with two operators that are sent as JSON in the body of the request, example:
{
  "operator1": 1,
  "operator2": 2
}

## How to build
Working with: 	Java version 1.8.0_333 and Apache Maven 3.8.5

#### 1. Clone repository from github:
Open Git Bash.
Change the current working directory to the location where you want the cloned directory.

```
$ git clone https://github.com/dokumura/calculator.git
```

#### 2. Generate artefact .jar:
Execute the following maven command in the project root folder where is located pom.xml

```
mvn clean package
```

#### 3. Run:
Execute the following maven command in the project root folder where is located pom.xml

```
mvn spring-boot:run
```
## How to test
Once we have the microservice running we can test it with Swagger:
http://localhost:8080/swagger-ui/

A POSTMAN collection is also included in the src/main/resources/collections directory.

