English below :point_down:




# Aluguel de Filmes

Este projeto é uma aplicação Java para gerenciar o aluguel de filmes, incluindo controle de preços, datas de entrega e pontuação de aluguel.

## Funcionalidades

- Cadastrar aluguéis de filmes
- Controlar preços e datas de entrega
- Gerenciar estoque de filmes
- Calcular pontuação de aluguel

## Tecnologias Utilizadas

- Java
- Maven
- JUnit
- Cucumber

## Estrutura do Projeto

- `src/main/java`: Contém o código fonte principal
  - `entidades`: Classes de entidades como `Filme`, `NotaAluguel`, `TipoAluguel`
  - `services`: Classes de serviço como `AluguelService`
  - `utils`: Classes utilitárias como `DateUtils`
- `src/test/java`: Contém os testes
  - `steps`: Definições de passos para os testes de Cucumber
  - `runners`: Classes para executar os testes de Cucumber
- `src/test/resources`: Contém os arquivos de recursos para os testes
  - `features`: Arquivos de feature do Cucumber

## Como Executar

1. Clone o repositório:
    ```sh
    git clone https://github.com/marialupiao/BDD-with-Cucumber-Java-.git
    ```
2. Navegue até o diretório do projeto:
    ```sh
    cd BDD-with-Cucumber-Java-
    ```
3. Compile o projeto usando Maven:
    ```sh
    mvn clean install
    ```
4. Execute os testes:
    ```sh
    mvn test
    ```

## Estrutura dos Testes

Os testes são escritos usando Cucumber e JUnit. As definições de passos estão localizadas no pacote `steps` e os arquivos de feature estão em `src/test/resources/features`.

### Exemplo de Arquivo de Feature

```gherkin
#language: pt

Funcionalidade: Alugar filme
  Como um usuário eu quero cadastrar aluguéis de filmes
  Para controlar preços e datas de entrega

  Cenario: Deve alugar um filme com sucesso
    Dado um filme
     | estoque | 2 |
     | preco   | 3 |
     | tipo    | comum |
    Quando alugar
    Entao o preco do aluguel sera 3 reais
    E a data de entrega sera em 1 dias
    E o estoque do filme tera 1 unidade
```

## Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Faça push para a branch (`git push origin feature/nova-feature`)
5. Crie um novo Pull Request

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo `LICENSE` para mais detalhes.



----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


# Movie Rental

This project is a Java application for managing movie rentals, including price control, delivery dates, and rental scoring.

## Features

- Register movie rentals
- Control prices and delivery dates
- Manage movie stock
- Calculate rental scores

## Technologies Used

- Java
- Maven
- JUnit
- Cucumber

## Project Structure

- `src/main/java`: Contains the main source code
  - `entidades`: Entity classes like `Filme`, `NotaAluguel`, `TipoAluguel`
  - `services`: Service classes like `AluguelService`
  - `utils`: Utility classes like `DateUtils`
- `src/test/java`: Contains the tests
  - `steps`: Step definitions for Cucumber tests
  - `runners`: Classes to run Cucumber tests
- `src/test/resources`: Contains resource files for tests
  - `features`: Cucumber feature files

## How to Run

1. Clone the repository:
    ```sh
    git clone https://github.com/marialupiao/BDD-with-Cucumber-Java-.git
    ```
2. Navigate to the project directory:
    ```sh
    cd BDD-with-Cucumber-Java-
    ```
3. Compile the project using Maven:
    ```sh
    mvn clean install
    ```
4. Run the tests:
    ```sh
    mvn test
    ```

## Test Structure

The tests are written using Cucumber and JUnit. The step definitions are located in the `steps` package, and the feature files are in `src/test/resources/features`.

### Example Feature File

```gherkin
#language: en

Feature: Rent movie
  As a user, I want to register movie rentals
  To control prices and delivery dates

  Scenario: Should rent a movie successfully
    Given a movie
     | stock | 2 |
     | price | 3 |
     | type  | common |
    When rent
    Then the rental price will be 3 reais
    And the delivery date will be in 1 day
    And the movie stock will have 1 unit

  Scenario: Should not rent a movie without stock
    Given a movie with 0 units in stock
    When rent
    Then it will not be possible due to lack of stock
    And the movie stock will have 0 units

  Scenario Outline: Should provide conditions according to rental type
      Given a movie with 2 units in stock
      And the rental price is <price> reais
      And the rental type is "<type>"
      When rent
      Then the rental price will be <value> reais
      And the delivery date will be in <days> days
      And the score will be <score> points

      Examples:
      | price |   type    | value | days | score |
      | 4     | extended  | 8     | 3    | 2     |
      | 4     | common    | 4     | 1    | 1     |
      | 5     | weekly    | 15    | 7    | 3     |
```

## Contribution

1. Fork the project
2. Create a branch for your feature (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a new Pull Request

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.
