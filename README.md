# WebMarket

   O projeto 'WebMarket' tem como objetivo criar uma plataforma online que funcione como um mercado virtual para vendedores autônomos. Oferecendo uma ampla variedade de produtos disponibilizados por indivíduos independentes. A plataforma visa permitir que esses vendedores alcancem um público mais diversificado e amplo. 
    Qualquer usuário pode criar uma conta para comprar produtos disponíveis no site. No entanto, para vender produtos, é necessário realizar um registro mais abrangente, o que possibilita o cadastro de mercadorias.

## Requisitos

- [] CRUD Usuários
- [] CRUD Produtos
- [] CRUD Carrinho
- [] Autenticação
    - [] Cadastro
    - [] Login
- [] Página Inicial
    - [] Ofertas
    - [] Categorias
    - [] Promoções do dia
- [] Carrinho
- [] Cadastrar produtos

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
Retorna um array com os todos os dados relacionados ao usuário cadastrado.

#### Exemplo de Resposta

```js
// GET /usuario
{
    "usuario": {
        "id": 1,
        "email": "abc1234@gmail.com",
        "nome": "Gustavo",
    },
    
    "carrinho":{
        "Produto 1":{
            "id": 123,
            "nome": "Computador",
            "categoria": "Eletronico"
        }
        "Produto 2":{
            "id": 234,
            "nome": "Camisa",
            "categoria": "Vestuario"
        }
    },
    
    "produtos_cadastrados":{
        "Produto 1":{
            "id": 123,
            "nome": "Computador",
            "categoria": "Eletronico"
        }
        "Produto 2":{
            "id": 234,
            "nome": "Camisa",
            "categoria": "Vestuario"
        }
    }
}
```

#### Códigos de Status

|código|descrição
|------|---------
|200| Dados retornados com sucesso
|401| Usuário não encontrado. Verifique seus dados

### Cadastrar Usuário

`POST` /usuario

Cadastra um usuário com os dados enviados no corpo da requisição

#### Corpo da Requisição
|campo|tipo|obrigatório
|-----|----|-----------
|email|string|✅
|senha|string|✅

#### Exemplo de Requisição

```js
// POST /usuario
{
    "email": "abc1234@gmail.com",
    "nome": "Gustavo"
}
```

#### Exemplo de Resposta

```js
{
    "id": 1
    "email": "abc1234@gmail.com",
    "nome": "Gustavo"
}
```

#### Códigos de Status

|código|descrição
|------|---------
|201| Usuário cadastrado com sucesso
|400| Falha no cadastro. Verifique os dados digitados