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


  Cenario: Nao deve alugar filme sem estoque
    Dado um filme com estoque de 0 unidades
    Quando alugar
    Entao nao sera possivel por falta de estoque
    E o estoque do filme tera 0 unidade

  Esquema do Cenario: Deve dar condicoes conforme tipo de aluguel
      Dado um filme com estoque de 2 unidades
      E que o preco do aluguel seja <preco> reais
      E que o tipo do aluguel seja categoria "<tipo>"
      Quando alugar
      Entao o preco do aluguel sera <valor> reais
      E a data de entrega sera em <qtdDias> dias
      E a pontuacao sera de <pontuacao> pontos

      Exemplos:
      | preco |   tipo    | valor | qtdDias | pontuacao |
      | 4     | extendido | 8     | 3       | 2         |
      | 4     | comum     | 4     | 1       | 1         |
      | 5     | semanal   | 15    | 7       | 3         |
