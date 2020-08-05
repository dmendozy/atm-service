Atm service
======================
# Getting Started
This project is based on Spring Boot microservices using the reactive stack, read more info there https://spring.io/reactive

## Frameworks 
* Spring Boot
* Spring Data - Reactive Mongo
* Webflux

## Setup
* Java 1.8
* Maven
* Mongo
* Docker

# Building
## Windows
1. Install [Docker Desktop](https://www.docker.com/products/docker-desktop).
2. Create an image and container for atm-service using the following code:
```
mvn install
docker build . -t config-service
docker run -p 8090:8090 --name config-service config-service
```
#Operations
| HTTP Verb  |      `/atm/deposit/{accountId}/{amount}`        |        `atm/withdraw/{accountId}/{amount}`      |       `atm/withdraw/{accountId}/{amount}/{bankId}`           |       `atm/withdraw/{accountId}/{amount}/{bankId}`           |
| ---------- | :---------------------------------------------: | :---------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
| **GET**   |    GET deposit made from ATM in account          |    GET withdraw made from ATM in account        |     GET deposit made from ATM in account to other bank       |    GET withdraw made from ATM in account to other bank       |

# Architecture

![Architecture](https://raw.githubusercontent.com/dmendozy/config-service/master/files/arch.png)

# Authors

* **Danny Mendoza Yenque** - *Everis Bootcamp Microservices July 2020* - [DannyMendoza](https://github.com/dmendozy)

