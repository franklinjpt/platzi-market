# Platzi Market

---

Welcome to the Platzi Market repository! This is a project developed as part of the Platzi course "[Curso de Java Spring](https://platzi.com/cursos/java-spring/)".

## Description

---

Platzi Market is an e-commerce platform that allows users to purchase products from different categories and view their purchase history. The project is built using Java Spring Boot.

## Features

---

- User registration and login
- Product browsing and purchase
- Purchase history view

## Installation and usage

---

To run the project locally, follow these steps:

1. Clone the repository: git clone https://github.com/franklinjpt/platzi-market.git
2. Open the project in your IDE
3. Do the PostgresSQL configuration below
4. Run the project
5. Open your browser and go to http://localhost:8080/platzi-market/api/swagger-ui/index.html
6. You can see the API documentation

You can also see a demo version [here](https://platzi-market-1-franklinjpt-dev.apps.rhoam-ds-prod.xe9u.p1.openshiftapps.com/platzi-market/api/swagger-ui/index.html).

### PostgresSQL

---

In order to have the same schema for database, you can create the database from the file `schema.sql` in the root of the project.
It's necessary to change the username and password in the file `application.yml` in src/main/resources in order to connect spring boot with the database.

## Aknowledgements

---

- Thanks to [Platzi](https://platzi.com/) for the course and the opportunity to learn and practice Java Spring Boot.

## Author

---

- [@franklinjpt](https://github.com/franklinjpt)
