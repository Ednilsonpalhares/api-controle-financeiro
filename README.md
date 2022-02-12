# API Controle Financeiro Alura
 alurachallengeback2
 
![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=dark&style=for-the-badge)
 
## Objetivo
Criar uma API Rest que faça o controle de Receitas e Despesas e gere relatório para controle finaneiro pessoal.

### Métodos

As requisições para a API devem seguir os padrões:

| Método   | Descrição                                             |
|:---------|-------------------------------------------------------|
| `GET`    | Retorna informações de um ou mais registros.          |
| `POST`   | Utilizado para criar unm novo registro.               |
| `PUT`    | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema.                        |

### Respostas

| Código | Descrição                                                                  |
|:-------|----------------------------------------------------------------------------|
| `200`  | Requisição executada com sucesso.                                          |
| `201`  | Recurso cadastrado.                                                        |
| `204`  | Sem conteúdo. 
| `400`  | Campos não válidos para requisição.                                        ||
| `404`  | Registro pesquisado não encontrado. (Referente a interação com o recurso). |
| `500`  | Erro interno no servidor.  

# Grupo de Recursos

***

## Receitas [/receitas]

As receitas são todos os ganhos com aplicações financeiras ou qualquer rendimento.

### Listar [GET]

+ API endopint
    + `receitas`
+ Response 200 (application/json) <br/>
    ```json
    [
      {
        "description": "Descrição da receita",
        "value": "Valor da receita",
        "date": "data da receita"
      },
      {
        "description": "Descrição da receita.",
        "value": "Valor da receita.",
        "date": "data da receita."
      }
    ]
    ```

### Cadastrar [POST]

+ API endopint
    + `receitas`
+ Request (/application/json)
    + Body
        ```json
        {
          "description": "Descrição da receita.",
          "value": "Valor da receita. (Ex.: 150.50).",
          "date": "Data da receita (Ex.: 2022-01-13)."
        }
        ```
+ Response 201 (application/json) <br/>
    ```json
    {
      "description": "Descrição da receita cadastrada.",
      "value": "Valor da receita cadastrada.",
      "date": "data da receita cadastrada."
    }
    ```
+ Response 400 (application/json) <br/>
    ```json
    {
      "status_code": 400,
      "message": "Request inválido."
    }
    ```

### Buscar por Ano e Mês [GET]

+ API endopint
    + `receitas/{ano}/{mes}`
+ Response 200 (application/json) <br/>
    ```json
    [
      {
        "description": "Descrição da receita",
        "value": "Valor da receita",
        "date": "data da receita"
      },
      {
        "description": "Descrição da receita.",
        "value": "Valor da receita.",
        "date": "data da receita."
      }
    ]
    ```
+ Response 204 (application/json) <br/>
  O body da resposta é retornada vazia.

### Detalhar [GET]

+ API endopint
    + `receitas/{id}`
+ Response 200 (application/json) <br/>
    ```json
    {
      "description": "Descrição da receita cadastrada.",
      "value": "Valor da receita cadastrada.",
      "date": "data da receita cadastrada."
    }
    ```
+ Response 404 (application/json) <br/>
    ```json
    {
    "status_code": 404,
    "message": "Receita não encontrada!"
    }
    ```

### Editar [PUT]

+ API endopint
    + `receitas/{id}`
+ Request (/application/json)
    + Body
      ```json
      {
        "description": "Descrição da receita.",
        "value": "Valor da receita. (Ex.: 150.50).",
        "date": "Data da receita (Ex.: 2022-01-13)."
      }
      ```
+ Response 200 (application/json) <br/>
    ```json
    {
      "description": "Descrição da receita editada.",
      "value": "Valor da receita editada.",
      "date": "data da receita editada."
    }
    ```
+ Response 404 (application/json) <br/>
    ```json
    {
      "status_code": 404,
      "message": "Receita não encontrada!"
    }
    ```
+ Response 422 (application/json) <br/>
    ```json
    {
       "status_code": 400,
       "message": "Request inválido."
    }

### Remover [DELETE]

+ API endopint
    + `receitas/{id}`
+ Response 200 (application/json) <br/>
 
+ Response 404 (application/json) <br/>
    ```json
    {
      "status_code": 404,
      "message": "Receita não encontrada!"
    }
    ```

## Despesas [/despesas]

As despesas são todos os gastos com aplicações financeiras ou qualquer outro custo.

### Listar [GET]

+ API endopint
    + `despesas`
+ Response 200 (application/json) <br/>
    ```json
    [
      {
        "description": "Descrição da despesa",
        "value": "Valor da despesa",
        "date": "data da despesa"
      },
      {
        "description": "Descrição da despesa.",
        "value": "Valor da despesa.",
        "date": "data da despesa."
      }
    ]
    ```

### Cadastrar [POST]

+ API endopint
    + `despesas`
+ Request (/application/json)
    + Body
        ```json
        {
          "description": "Descrição da despesa.",
          "value": "Valor da despesa. (Ex.: 150.50).",
          "date": "Data da despesa (Ex.: 2022-01-13)."
        }
        ```
+ Response 201 (application/json) <br/>
    ```json
    {
      "description": "Descrição da despesa cadastrada.",
      "value": "Valor da despesa cadastrada.",
      "date": "data da despesa cadastrada."
    }
    ```
+ Response 400 (application/json) <br/>
    ```json
    {
       "status_code": 400,
       "message": "Request inválido."
    }
    ```

### Buscar por Ano e Mês [GET]

+ API endopint
    + `despesas/{ano}/{mes}`
+ Response 200 (application/json) <br/>
    ```json
    [
      {
        "description": "Descrição da despesa.",
        "value": "Valor da despesa.",
        "date": "data da despesa."
      },
      {
        "description": "Descrição da despesa.",
        "value": "Valor da despesa.",
        "date": "data da despesa."
      }
    ]
    ```
+ Response 204 (application/json) <br/>
  O body da resposta é retornada vazia.

### Detalhar [GET]

+ API endopint
    + `despesas/{id}`
+ Response 200 (application/json) <br/>
    ```json
    {
      "description": "Descrição da despesa cadastrada.",
      "value": "Valor da despesa cadastrada.",
      "date": "data da despesa cadastrada."
    }
    ```
+ Response 204 (application/json) <br/>
  O body da resposta é retornada vazia.

### Editar [PUT]

+ API endopint
    + `despesas/{id}`
+ Request (/application/json)
    + Body
      ```json
      {
        "description": "Descrição da despesa.",
        "value": "Valor da despesa. (Ex.: 150.50).",
        "date": "Data da despesa (Ex.: 2022-01-13)."
      }
      ```
+ Response 200 (application/json) <br/>
    ```json
    {
      "description": "Descrição da despesa editada.",
      "value": "Valor da despesa editada.",
      "date": "data da despesa editada."
    }
    ```
+ Response 404 (application/json) <br/>
    ```json
    {
      "status_code": 404,
      "message": "Despesa não encontrada!"
    }
    ```
+ Response 422 (application/json) <br/>
    ```json
    {
       "status_code": 400,
       "message": "Request inválido."
    }

### Remover [DELETE]

+ API endopint
    + `despesas/{id}`
+ Response 200 (application/json) <br/>

+ Response 404 (application/json) <br/>
    ```json
    {
      "status_code": 404,
      "message": "Despesa não encontrada!"
    }
    ```

## Resumo Mensal [/resumo/{ano}/{mes}]

O resumo do mês contem as seguintes informações:

- Valor total das receitas no mês.
- Valor total das despesas no mês.
- Saldo final no mês.
- Valor total gasto no mês em cada uma das categorias.

### Listar [GET]

+ API endopint
    + `despesas/{ano}/{mes}`
+ Response 200 (application/json) <br/>
    ```json
    {
      "valorTotalReceitasPorMes": "Valor total de receitas",
      "valorTotalDespesasPorMes": "Valor total de despesas",
      "saldoFinalNoMes": "Saldo (receitas - despesas)",
      "gastosNoMesPorCategoria": [
        {
          "categoria": "descricao da categoria",
          "valorTotal": "Valor total"
        }
      ]
    }
    ```
