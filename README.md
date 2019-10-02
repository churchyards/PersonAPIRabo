# PersonAPIRabo
Rabobank Technical Assesment Person API. It will store and retrieve the PersonDTO.

### Prerequisites

For building and running the application you need:

- [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Docker](https://www.docker.com/products/docker-desktop)

## Running the application locally

You can build application by using Maven to package everything and Docker Compose to launch a postgres container and then the app.

```shell
mvnw clean install
docker-compose up
```

## Running the tests

To run the tests you can simply run JUnit on the whole project(or the specific classes) using your IDE or use maven: 

```shell
mvnw clean verify
```

## API Specification

After the application is up and running you can visit the [Swagger UI](http://localhost:8080/swagger-ui.html)
to get API endpoints specifications.

Or you can use a tool like [Postman](https://www.getpostman.com/) to send a Get request to the following URL get a list of people or a secific person:
```shell
http://localhost:8080/v1/person
```
```shell
http://localhost:8080/v1/person/1
```
 - send a Post request to the following URL with an example body to store a person:
```shell
http://localhost:8080/v1/person
```
Example body:
```shell
{
	"firstName":"John",
	"lastName":"Smith",
	"dateOfBirth":"1989-06-18",
	"address": {
		"street": "Croeselaan 18",
		"city": "Utrecht"
	}
}
```
