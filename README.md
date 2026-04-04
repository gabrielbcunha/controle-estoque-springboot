# Sistema de Controle de Estoque - API REST com Spring Boot
API REST desenvolvida em Java utilizando Spring Boot para gerenciamento simples de um estoque de Produtos.

Esse projeto foi desenvolvido com o objetivo de exercitar o desenvolvimento de sistemas Backend, incluindo as praticas de:
- Arquitetura em camadas
- API REST
- DTOs
- Validação de dados
- Persistencia com JPA
- Boas práticas de organização de projeto

## Funcionalidades
A API permite:
- Cadastrar produtos
- Listar todos os produtos
- Buscar produtos por ID
- Atualizar parcialmente um produto
- Remover um produto
  
## Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation (Jakarta Validation)
- Lombok
- H2 Database
- Maven

## Arquitetura de projeto
```bash
src/main/java/
   ├── br.com.gabrielbcunha.controleestoquespringboot
       ├── dto -> Objetos de transferência de dados
       ├── controller -> Camada responsável pelos Endpoints da API
       ├── service -> Camada responsável pelas regras de negócio       
       ├── entity -> Entidades JPA
       ├── repository -> Comunicação com o banco de dados
       └── ControleEstoqueSpringbootApplication -> Executor da aplicação
```

## Estrutura de DTO'S
Para  melhor organização de validações na API foram utilizados diferentes DTOs
- ProdutoCreateRequest -> utilizado para a criação de produtos, contem validações de váriaveis
- ProdutoPatchRequest -> utilizado para a atualização parcial de produtos
- ProdutoResponse -> utilizado para respostas da API

## Endpoints da API

### Criar produto
POST /produtos

Exemplo de produto:
```json
{
    "nome": "Bicicleta preta",
    "preco": 800.00,
    "quantidade": 20
}
```
### Listar Todos os Produtos
GET /produtos

### Buscar produto por ID
GET /produtos/{id}

### Atualizar produto (PATCH)
PATCH /produtos/{id}

Exemplo de atualização parcial, somente os dados enviados serão atualizados:
```json
{
    "preco": 600.00
}
```

### Remover produto
DELETE /produtos/{id}

## Validação de dados 
O projeto utiliza Bean Validation para garantir a integridade dos dados recebidos pela API, algumas das validações utilizadas são:
- @NotBlank -> nome obrigatório
- @NotNull -> preço obrigatório
- @PositiveOrZero -> preço e quantidade devem ser maiores o iguais a zero

## Banco de dados

O projeto utiliza **H2 Database**, um banco de dados em memória utilizado para desenvolvimento e testes.

Após executar a aplicação, o console do H2 pode ser acessado em: `http://localhost:8080/h2-console`

As configurações do banco estão disponíveis no arquivo `application-example.properties`.
Basta copiá-las para um arquivo `application.properties`.

# Como executar o projeto
1 - Clonar o repositorio em sua IDE de preferência (InteliJ, Eclipse, VSCode)
```bash
git clone https://github.com/seu-usuario/controle-estoque-springboot.git
```

2 - Abrir o projeto na IDE e configurar o application.properties

3 - Executar a aplicação ControleEstoqueSpringbootApplication

4 - A API estará disponível em: `http://localhost:8080`

## Melhorias futuras
Possíveis evoluções do projeto:
- Tratamento global de exceções (@ControllerAdvice)
- Padronização de respostas de erro
- Paginação de resultados
- Testes unitários
- Autenticação com Spring Security
