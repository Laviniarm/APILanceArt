# Integracao Frontend (Angular) com API LanceArt

Este documento define o contrato de integracao entre o frontend Angular e esta API.

## Base URL

- Local: `http://localhost:8080`

Sugestao para Angular:

- `environment.ts`:
  - `apiBaseUrl: 'http://localhost:8080'`

## Recursos e Endpoints

## Users

- `GET /users`
- `GET /users/{id}`
- `POST /users`
- `PUT /users/{id}`
- `DELETE /users/{id}`

### Request - UserCreateDTO

```json
{
  "nome": "Joao Silva",
  "email": "joao@email.com",
  "senha": "123456"
}
```

### Response - UserResponseDTO

```json
{
  "id": 1,
  "nome": "Joao Silva",
  "email": "joao@email.com"
}
```

---

## Works of Art

- `GET /works-of-art`
- `GET /works-of-art/{id}`
- `POST /works-of-art`
- `PUT /works-of-art/{id}`
- `DELETE /works-of-art/{id}`
- `GET /works-of-art/user/{userId}`

### Request - WorkOfArtCreateDTO

```json
{
  "title": "Mona Lisa",
  "artist": "Leonardo da Vinci",
  "year": 1503,
  "initialValue": 1000.0,
  "image": "https://example.com/imagem.jpg",
  "userId": 1
}
```

### Response - WorkOfArtResponseDTO

```json
{
  "id": 10,
  "title": "Mona Lisa",
  "artist": "Leonardo da Vinci",
  "year": 1503,
  "initialValue": 1000.0,
  "image": "https://example.com/imagem.jpg",
  "user": {
    "id": 1,
    "nome": "Joao Silva"
  }
}
```

---

## Bids

- `GET /bids`
- `GET /bids/{id}`
- `POST /bids`
- `PUT /bids/{id}`
- `DELETE /bids/{id}`

### Request - BidCreateDTO

```json
{
  "valor": 1500.5,
  "data": "2026-04-01T20:30:00-03:00",
  "userId": 1,
  "workOfArtId": 10
}
```

### Response - BidResponseDTO

```json
{
  "id": 5,
  "valor": 1500.5,
  "data": "2026-04-01T20:30:00-03:00",
  "userId": 1,
  "workOfArtId": 10
}
```

## Regras importantes para o frontend

- `Bid.data` deve ser enviado em formato ISO-8601 com offset:
  - Exemplo valido: `2026-04-01T20:30:00-03:00`
- `Bid.valor` deve ser numero e maior que zero.
- `WorkOfArt.userId`, `Bid.userId` e `Bid.workOfArtId` devem referenciar IDs existentes.

## Erros HTTP esperados

- `400 Bad Request`: payload invalido (campos obrigatorios, validacoes, formato de dados).
- `404 Not Found`: entidade nao encontrada por ID.
- `500 Internal Server Error`: erro inesperado.

Sugestao no Angular:

- Criar um interceptor para tratar erros HTTP e mapear mensagens amigaveis para UI.

## Interfaces TypeScript sugeridas

```ts
export interface UserCreateDTO {
  nome: string;
  email: string;
  senha: string;
}

export interface UserResponseDTO {
  id: number;
  nome: string;
  email: string;
}

export interface WorkOfArtCreateDTO {
  title: string;
  artist: string;
  year?: number;
  initialValue: number;
  image?: string;
  userId: number;
}

export interface UserSummaryDTO {
  id: number;
  nome: string;
}

export interface WorkOfArtResponseDTO {
  id: number;
  title: string;
  artist: string;
  year?: number;
  initialValue: number;
  image?: string;
  user: UserSummaryDTO;
}

export interface BidCreateDTO {
  valor: number;
  data: string; // ISO-8601 com offset
  userId: number;
  workOfArtId: number;
}

export interface BidResponseDTO {
  id: number;
  valor: number;
  data: string; // ISO-8601 com offset
  userId: number;
  workOfArtId: number;
}
```

## Checklist de implementacao no Angular

- Criar servicos:
  - `users.service.ts`
  - `works-of-art.service.ts`
  - `bids.service.ts`
- Centralizar base URL em `environment.ts`.
- Usar interfaces acima para tipagem.
- Padronizar tratamento de erro no interceptor.

