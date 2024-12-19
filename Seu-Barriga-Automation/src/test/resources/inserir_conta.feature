#language: pt
Funcionalidade: Cadastro de contas

  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  Contexto:
    Dado que estou acessando a aplicacao
    Quando informo o usuario "abc@org"
    E a senha "abc123"
    E seleciono entrar
    Então visualizo a pagina inicial
    Quando seleciono Contas
    E seleciono Adicionar

  Esquema do Cenario: Deve validar regras cadastro de contas
    Quando informo a conta "<conta>"
    E seleciono Salvar
    Então recebo a mensagem "<mensagem>"
    Exemplos:

      | conta            | mensagem                           |
      |                  | Informe o nome da conta            |
      | Conta de Teste   | Conta adicionada com sucesso!      |
      | Conta mesmo nome | Já existe uma conta com esse nome! |