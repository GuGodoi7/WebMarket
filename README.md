# WebMarket

   O projeto 'WebMarket' tem como objetivo criar uma plataforma online que funcione como um mercado virtual para vendedores autônomos. Oferecendo uma ampla variedade de produtos disponibilizados por indivíduos independentes. A plataforma visa permitir que esses vendedores alcancem um público mais diversificado e amplo. 
    Qualquer usuário pode criar uma conta para comprar produtos disponíveis no site. No entanto, para vender produtos, é necessário realizar um registro mais abrangente, o que possibilita o cadastro de mercadorias.

## Requisitos

- [ ] CRUD Usuários
- [ ] CRUD Produtos
- [ ] CRUD Carrinho
- [ ] Autenticação
    - [ ] Cadastro
    - [ ] Login
- [ ] Página Inicial
    - [ ] Ofertas
    - [ ] Categorias
    - [ ] Promoções do dia
- [ ] Carrinho
- [ ] Cadastrar produtos

## Documentação da API

### Endpoints

- Login usuário
- Cadastrar usuário
- Editar dados usuário
- Remover usuário

- Cadastrar produtos
- Editar dados do produto
- Remover produto

- Adicionar produtos ao carrinho
- Remover produtos do carrinho

### Login Usuário

`GET` /usuario
Retorna os dados relacionados ao usuário cadastrado.

#### Exemplo de Resposta

```js
// GET /usuario
{
    "id": 1,
    "email": "abc1234@gmail.com",
    "nome": "Gustavo"

}
```

#### Códigos de Status

|código|descrição
|------|---------
|200| Dados retornados com sucesso
|401| Usuário não encontrado. Verifique seus dados
<br>

### Cadastrar Usuário

`POST` /usuario

Cadastra um usuário com os dados enviados no corpo da requisição

#### Corpo da Requisição
|campo|tipo|obrigatório
|-----|----|:-----------:
|email|string|✅
|senha|string|✅

#### Exemplo de Requisição

```js
// POST /usuario
{
    "email": "xyz789@gmail.com",
    "nome": "Matheus"
}
```

#### Exemplo de Resposta

```js
{
    "id": 1,
    "email": "xyz789@gmail.com",
    "nome": "Matheus",
}
```
#### Códigos de Status

|código|descrição
|------|---------
|201| Usuário cadastrado com sucesso
|400| Falha no cadastro. Verifique os dados digitados
<br>

### Remover Usuário

`DELETE` /usuario/`{id}`

Apaga o usuario com o `id` informado no path

#### Códigos de Status

|código|descrição
|------|---------
|204| Usuário apagado com sucesso
|402| Não autenticado. Se autentique em /usuario
|404| Erro ao deletar. Verifique o `id` informado
<br>

### Atualizar Usuário

`Put` /usuario/`{id}`

Atualiza um usuário com o `id` informado no path, utilizando dados enviados no corpo da requisição.

#### Corpo da Requisição
|campo|tipo|obrigatório
|-----|----|:-----------:
|email|string|✅
|senha|string|✅

#### Exemplo de Requisição

```js
// POST /usuario
{
    "email": "uwxyz789@gmail.com",
    "nome": "Matheus Silva"
}
```

#### Exemplo de Resposta

```js
{
    "id": 1,
    "email": "uwxyz789@gmail.com",
    "nome": "Matheus Silva",
}
```
#### Códigos de Status

|código|descrição
|------|---------
|203| Usuário atualizado com sucesso
|402| Não autenticado. Se autentique em /usuario
|404| Falha na atualização. Verifique os dados digitados
