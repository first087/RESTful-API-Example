# RESTful API Example Project

This repository has many language programming with the same proposition.

## Language/Framework
| Language / Framework | IDE | Progress | Remark |
| --- | --- | :---: | --- |
| Node.js / Express | Visual Studio Code | Done | |
| Node.js / Hapi | Visual Studio Code | Done | |
| Java / Spring Boot | IntelliJ IDEA | In progress | |
| ... | ... | ... |

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
