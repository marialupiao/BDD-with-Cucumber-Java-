English below :point_down:


# Automação de Gerenciamento de Contas

Este projeto é uma suíte de testes automatizados para a funcionalidade de gerenciamento de contas de uma aplicação web. Ele utiliza Java, Maven, Selenium e Cucumber para realizar testes de ponta a ponta.

## Estrutura do Projeto

- `src/test/java/runners/RunnerTest.java`: Contém a configuração do runner de testes para o Cucumber.
- `src/test/java/steps/StepDefinitions.java`: Contém as definições de passos para os cenários do Cucumber.
- `src/test/resources/inserir_conta.feature`: Contém o arquivo de feature com os cenários de teste escritos em Gherkin.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação usada para escrever os scripts de teste.
- **Maven**: Ferramenta de automação de build usada para gerenciar dependências e executar testes.
- **Selenium**: WebDriver usado para automatizar a interação com o navegador web.
- **Cucumber**: Framework usado para escrever e executar os cenários de teste no estilo BDD.

## Pré-requisitos

- Java JDK 11 ou superior
- Maven 3.6 ou superior
- ChromeDriver (compatível com a versão do Chrome instalada em sua máquina)

## Executando os Testes

1. Clone o repositório:
    ```sh
    git clone https://github.com/marialupiao/BDD-with-Cucumber-Java-.git
    cd BDD-with-Cucumber-Java-
    ```

2. Instale as dependências:
    ```sh
    mvn clean install
    ```

3. Execute os testes:
    ```sh
    mvn test
    ```

## Arquivo de Feature

O arquivo de feature `inserir_conta.feature` 

- **Deve validar regras cadastro de contas**: Testa a inserção e validação de contas com diferentes condições.

## Definições de Passos

As definições de passos em `StepDefinitions.java` mapeiam os passos do Gherkin para métodos Java. Esses métodos usam o Selenium WebDriver para interagir com a aplicação web e realizar asserções.

## Relatórios

Os resultados dos testes são gerados nos formatos HTML e JSON e podem ser encontrados no diretório target/reports após a execução dos testes. 
Além disso, capturas de tela da execução dos testes são salvas no diretório target/screenshots.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


# Account Management Automation

This project is an automated testing suite for the account management functionality of a web application. It uses Java, Maven, Selenium, and Cucumber to perform end-to-end tests.

## Project Structure

- `src/test/java/runners/RunnerTest.java`: Contains the test runner configuration for Cucumber.
- `src/test/java/steps/StepDefinitions.java`: Contains the step definitions for the Cucumber scenarios.
- `src/test/resources/inserir_conta.feature`: Contains the feature file with the test scenarios written in Gherkin.

## Technologies Used

- **Java**: Programming language used for writing the test scripts.
- **Maven**: Build automation tool used for managing dependencies and running tests.
- **Selenium**: WebDriver used for automating web browser interaction.
- **Cucumber**: Framework used for writing and executing the test scenarios in a BDD style.

## Prerequisites

- Java JDK 11 or higher
- Maven 3.6 or higher
- ChromeDriver (compatible with the version of Chrome installed on your machine)

## Running the Tests

1. Clone the repository:
    ```sh
    git clone https://github.com/marialupiao/BDD-with-Cucumber-Java-.git
    cd BDD-with-Cucumber-Java-
    ```

2. Install the dependencies:
    ```sh
    mvn clean install
    ```

3. Run the tests:
    ```sh
    mvn test
    ```

## Feature File

The feature file `inserir_conta.feature` contains the following scenarios:

- **Should validate account registration rules**: Tests the insertion and validation of accounts under different conditions.

## Step Definitions

The step definitions in `StepDefinitions.java` map the Gherkin steps to Java methods. These methods use Selenium WebDriver to interact with the web application and perform assertions.

## Reporting

The test results are generated in both HTML and JSON formats and can be found in the `target/reports` directory after running the tests. 
Additionally, screenshots of the test execution are saved in the `target/screenshots` directory.


