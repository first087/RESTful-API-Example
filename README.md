# RESTful API Example Project

This repository has many language programming with the same proposition.

## Language/Framework
| No. | Language / Framework | IDE | Contributor | Progress | Etc. |
| ---: | :---: | :---: | :---: |  :---: | --- |
| 1. | [Node.js](https://nodejs.org/) / [Express](https://expressjs.com/) | [Visual Studio Code](https://code.visualstudio.com/) | [first087](https://github.com/first087) | Done | Node.js 14.x / Express 4.x |
| 2. | [Node.js](https://nodejs.org/) / [Hapi](https://hapi.dev/) | [Visual Studio Code](https://code.visualstudio.com/) | [first087](https://github.com/first087) | Done | Node.js 14.x / Hapi 20.x |
| 3. | [Java](https://www.java.com/) / [Spring Boot](https://spring.io/projects/spring-boot) | [IntelliJ IDEA](https://www.jetbrains.com/idea/) | [first087](https://github.com/first087) | Done | JDK or OpenJDK 11+ / Gradle 7.1.1 / Spring Boot 2.5.3 |
| 4. | [Kotlin](https://kotlinlang.org/) / [Spring Boot](https://spring.io/projects/spring-boot) | [IntelliJ IDEA](https://www.jetbrains.com/idea/) | [first087](https://github.com/first087) | Done | JDK or OpenJDK 11+ / Gradle 7.1.1 / Spring Boot 2.5.3 |
| | Go / ... | | _Need You!_ | | |
| | Python / ... | | _Want You!_ | | |
| | php / ... | | _Need You!_ | | |
| | C# .NET Core / ... | | ... | | |
| | ... | | _And You!_ | |

## Proposition
Define `store` for save `item` type `Array of String` and initial value is `Init item`

| Method | Route | Request body (JSON) | Response body (JSON) | Success (HTTP Status) | Fail (HTTP Status) | Description |
| :---: | --- | --- | --- | :---: | :---: | --- |
| `GET` | `/item/` | | `{"items":["Init item",...]}` | 200 | | Get all items |
| `GET` | `/item/{index}` | | `{"item":"Init item"}` | 200 | 404 | Get item by index |
| `POST` | `/item/` | `{"item":"New item"}` | | 201 | 400 | Add item |
| `PUT` | `/item/{index}` | `{"item":"Update item"}` | `{"oldItem":"Old item"}` | 200 | 400/404 | Update item by index |
| `DELETE` | `/item/{index}` | | `{"removeItem":"Remove item"}` | 200 | 404 | Delete item by index |

- HTTP Status `400` when bad input
- HTTP Status `404` when index out of range

## Optional
0. Create `Dockerfile` for build docker image for your app.
0. Add service in docker compose (`docker-compose.yml`)
0. Config reverse proxy in NGINX (`nginx/conf.d/route.d/`)

## Welcome to Fork
0. Develop on your branch, create branch from `master`.
0. Create pull request to branch `dev`.
