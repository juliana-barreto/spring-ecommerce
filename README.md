# 🛒 E-commerce API

API RESTful desenvolvida como projeto final do curso de Desenvolvimento Back-end do SENAI. O sistema gerencia o fluxo de
clientes e pedidos de um e-commerce, aplicando boas práticas de arquitetura, validações de negócio e tratamento de
erros.

Este projeto tem como objetivo demonstrar a construção de uma aplicação robusta utilizando Java e Spring Boot. O sistema
permite o cadastro de clientes e a realização de pedidos com cálculo automático de valores, garantindo a integridade dos
dados através de relacionamentos em banco de dados relacional.

## 📖 Documentação da API (Swagger)

Com a aplicação rodando, acesse a documentação interativa para testar os endpoints:

👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Exemplos de Endpoints

| Método | Rota            | Descrição                                   |
|:-------|:----------------|:--------------------------------------------|
| `POST` | `/clientes`     | Cadastra um novo user                       |
| `GET`  | `/clientes`     | Lista todos os clientes                     |
| `POST` | `/pedidos`      | Cria um novo order (com cálculo automático) |
| `GET`  | `/pedidos/{id}` | Busca detalhes de um order                  |

## 🛠 Built With

<div style="display: inline_block"><br>
  <img align="center" src="https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img align="center" src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" />
  <img align="center" src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" />
  <img align="center" src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white" />
  <img align="center" src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black" />
  <img align="center" src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" />
</div>
