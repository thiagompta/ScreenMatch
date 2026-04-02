# 🎬 ScreenMatch - Backend

API REST desenvolvida em Java com Spring Boot para gerenciamento de séries, temporadas e episódios, com integração a API externa e uso de IA para enriquecimento de dados.

---

## 🚀 Tecnologias utilizadas

* ☕ Java 17
* 🌱 Spring Boot
* 📦 Spring Data JPA
* 🐘 PostgreSQL
* 🔗 API externa (OMDb)
* 🤖 Integração com IA (Gemini)
* 🔄 Maven

---

## 📁 Estrutura do projeto

```
br.com.alura.screenmatch
│
├── controller       # Endpoints REST
├── service          # Regras de negócio
├── repository       # Acesso ao banco de dados
├── model            # Entidades (Serie, Episodio)
├── dto              # Objetos de transferência
```

---

## ⚙️ Configuração do ambiente

### 🔑 Variáveis de ambiente

```bash
GEMINI_API_KEY=SEU_TOKEN_AQUI
```

---

### 🐘 Banco de dados (PostgreSQL)

Crie o banco:

```sql
CREATE DATABASE screenmatch;
```

Configure no `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/screenmatch
spring.datasource.username=postgres
spring.datasource.password=123456

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Como rodar o projeto

```bash
mvn spring-boot:run
```

A API estará disponível em:

```
http://localhost:8080
```

---

## 📡 Endpoints principais

### 🎬 Séries

| Método | Endpoint     | Descrição             |
| ------ | ------------ | --------------------- |
| GET    | /series      | Lista todas as séries |
| GET    | /series/{id} | Busca série por ID    |
| POST   | /series      | Cadastra nova série   |
| PUT    | /series/{id} | Atualiza série        |

---

### 📺 Temporadas e Episódios

| Método | Endpoint                         | Descrição                     |
| ------ | -------------------------------- | ----------------------------- |
| GET    | /series/{id}/temporadas/todas    | Lista todas temporadas        |
| GET    | /series/{id}/temporadas/{numero} | Lista episódios por temporada |

---

## 🤖 Integração com IA (Gemini)

O projeto utiliza a API do Gemini para:

* Traduzir sinopses
* Melhorar descrições automaticamente

Exemplo de uso:

```java
String traducao = ConsultaGemini.obterTraducao(texto);
```

---

## 🔥 Funcionalidades

* ✔ Cadastro de séries
* ✔ Consulta por ID
* ✔ Listagem de temporadas
* ✔ Listagem de episódios
* ✔ Integração com API externa
* ✔ Tradução automática com IA
* ✔ Persistência em banco relacional

---

## 🧠 Arquitetura

O projeto segue o padrão:

* Controller → recebe requisições
* Service → regra de negócio
* Repository → acesso ao banco
* DTO → transporte de dados

---

## 📌 Melhorias futuras

* 🔍 Busca por nome
* ⭐ Sistema de favoritos
* 📄 Paginação
* 🔐 Autenticação com JWT
* 🎨 Integração completa com frontend

---

## 👨‍💻 Autor

Thiago Silva

---

## 📄 Licença

Este projeto é para fins de estudo e portfólio.
