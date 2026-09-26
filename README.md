# Baozi Store API

API REST desenvolvida como atividade prática da disciplina de Desenvolvimento Web Back-End (UNINTER), simulando o sistema de controle de clientes, produtos e pedidos de uma pequena loja fictícia de pãozinho chinês.

## Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA / Hibernate
- MySQL
- Maven

## Entidades

- **Cliente** — id, nome, clienteDesde
- **Produto** — id, nome, preco, estoque
- **Pedido** — id, clienteId, produtoId, quantidade

## Endpoints

Cada entidade (`/client`, `/product`, `/order`) expõe:

| Método | Rota      | Descrição            |
| ------ | --------- | --------------------- |
| POST   | `/`       | Criar registro         |
| GET    | `/`       | Listar todos           |
| GET    | `/{id}`   | Consultar por ID       |
| PUT    | `/{id}`   | Atualizar registro     |
| DELETE | `/{id}`   | Remover registro       |

## Como rodar o projeto

1. Clone o repositório e entre na pasta `apirest`.
2. Configure o banco MySQL em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/baozi_store?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
```

3. Rode a aplicação:

```bash
./mvnw spring-boot:run
```

4. A API sobe em `http://localhost:8080`.

## Testes

Os endpoints foram testados via Postman (prints em anexo na entrega da atividade).

## Autor

Matheus Amon — projeto acadêmico (UNINTER, ADS)
