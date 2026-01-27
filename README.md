# E-commerce API 

Esta API RESTful foi desenvolvida como o **projeto final do curso de Desenvolvimento Back-end do SENAI**. O sistema é responsável por gerenciar o fluxo operacional de um e-commerce, focando na gestão de clientes e processamento de pedidos.

O projeto demonstra a aplicação de conhecimentos avançados em Java e Spring Boot, priorizando:
* **Arquitetura:** Organização clara de responsabilidades entre as camadas (Controller, Service, Repository).
* **Regras de Negócio:** Cálculo automático de valores e validações de integridade.
* **Persistência:** Relacionamentos complexos em banco de dados relacional com Hibernate.

## Funcionalidades Principais

* **Gestão de Clientes:** CRUD completo com validações de dados.
* **Fluxo de Pedidos:** Registro de vendas com vinculação automatizada a clientes existentes.
* **Cálculo de Valores:** Lógica interna para processamento de totais de pedidos.
* **Tratamento de Erros:** Respostas HTTP padronizadas para exceções de negócio e falhas de sistema.

## Tecnologias e Ferramentas

<div align="left">
  <img src="https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" />
  <img src="https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white" />
  <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white" />
  <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black" />
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" />
</div>

## 4. Documentação da API (Swagger)

A API utiliza o **Swagger** para fornecer uma interface interativa de testes. Com a aplicação em execução, você pode explorar todos os endpoints disponíveis.

* **URL Local:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Principais Endpoints

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/clientes` | Cadastra um novo cliente no sistema. |
| `GET` | `/clientes` | Retorna a lista de todos os clientes cadastrados. |
| `POST` | `/pedidos` | Cria um novo pedido vinculado a um cliente. |
| `GET` | `/pedidos/{id}` | Busca os detalhes completos de um pedido específico. |

