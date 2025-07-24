# Backend Challenge - ITI Digital

Este projeto implementa uma API REST para **validação de senhas**, conforme o desafio proposto pela [iti digital](https://github.com/itidigital/backend-challenge).

---

## ✅ Regras para senha válida

Uma senha é considerada **válida** se:

- Possuir **9 ou mais caracteres**
- Conter **pelo menos 1 dígito**
- Conter **pelo menos 1 letra minúscula**
- Conter **pelo menos 1 letra maiúscula**
- Conter **pelo menos 1 caractere especial** entre: `!@#$%^&*()-+`
- **Não possuir caracteres repetidos**

---

## 🚀 Como executar

### Requisitos
- Java 17
- Maven 3.8+

### Rodar localmente
```bash
./mvnw spring-boot:run
```

### Rodar com Docker
```bash
docker build -t backendchallenge .
docker run -p 8080:8080 backendchallenge
```

---

## 🧪 Testes com curl

### ✅ Senha válida
```bash
curl -X POST http://localhost:8080/validate-password \
  -H "Content-Type: application/json" \
  -d '{"password": "AbTp9!fok"}'
```

**Resposta esperada:**
```json
{ "isValid": true }
```

---

### ❌ Senha com caractere repetido
```bash
curl -X POST http://localhost:8080/validate-password \
  -H "Content-Type: application/json" \
  -d '{"password": "AbTp9!foo"}'
```

**Resposta esperada:**
```json
{ "isValid": false }
```

---

### ❌ Senha sem caractere especial
```bash
curl -X POST http://localhost:8080/validate-password \
  -H "Content-Type: application/json" \
  -d '{"password": "AbTp9fokz"}'
```

---

### ❌ Senha menor que 9 caracteres
```bash
curl -X POST http://localhost:8080/validate-password \
  -H "Content-Type: application/json" \
  -d '{"password": "Ab9!fok"}'
```

---

## 📦 Endpoint

### POST `/validate-password`

**Request:**
```json
{
  "password": "AbTp9!fok"
}
```

**Response:**
```json
{
  "isValid": true
}
```

---

## 🧱 Estrutura do projeto

- `controller` — endpoint REST
- `service` — lógica de orquestração
- `domain` — entidade de domínio (`Password`)
- `dto` — objetos de entrada/saída da API
- `validator` — regras de validação da senha

---

Desafio implementado com 💡 Clean Architecture + SOLID.---

## 🧪 Testes adicionais (baseados nos exemplos do desafio)

### ❌ Senha vazia
```bash
curl -X POST http://localhost:8080/validate-password \
  -H "Content-Type: application/json" \
  -d '{"password": ""}'
```

### ❌ Senha com caracteres repetidos ("aa")
```bash
curl -X POST http://localhost:8080/validate-password \
  -H "Content-Type: application/json" \
  -d '{"password": "aa"}'
```

### ❌ Senha com caracteres diferentes mas inválidos ("ab")
```bash
curl -X POST http://localhost:8080/validate-password \
  -H "Content-Type: application/json" \
  -d '{"password": "ab"}'
```

### ❌ Senha com letras repetidas e sem número/especial ("AAAbbbCc")
```bash
curl -X POST http://localhost:8080/validate-password \
  -H "Content-Type: application/json" \
  -d '{"password": "AAAbbbCc"}'
```

### ❌ Senha com `o` repetido ("AbTp9!foo")
```bash
curl -X POST http://localhost:8080/validate-password \
  -H "Content-Type: application/json" \
  -d '{"password": "AbTp9!foo"}'
```

### ❌ Senha com `A` repetido ("AbTp9!foA")
```bash
curl -X POST http://localhost:8080/validate-password \
  -H "Content-Type: application/json" \
  -d '{"password": "AbTp9!foA"}'
```

### ❌ Senha com espaço ("AbTp9 fok")
```bash
curl -X POST http://localhost:8080/validate-password \
  -H "Content-Type: application/json" \
  -d '{"password": "AbTp9 fok"}'
```

### ✅ Senha válida ("AbTp9!fok")
```bash
curl -X POST http://localhost:8080/validate-password \
  -H "Content-Type: application/json" \
  -d '{"password": "AbTp9!fok"}'
```