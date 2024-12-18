package steps;

import entidades.Filme;
import entidades.NotaAluguel;
import entidades.TipoAluguel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import services.AluguelService;
import utils.DateUtils;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class StepDefinitions {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private TipoAluguel tipoAluguel;

    @Dado("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(int int1) throws Throwable {
        filme = new Filme();
        filme.setEstoque(int1);
    }

    @E("que o preco do aluguel seja {int} reais")
    public void queOPrecoDoAluguelSejaReais(int int1) throws Throwable {
        filme.setAluguel(int1);
    }

    @Quando("alugar")
    public void alugar() throws Throwable {
        try {
            nota = aluguel.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }

    @Entao("o preco do aluguel sera {int} reais")
    public void oPrecoDoAluguelSeraReais(int int1) throws Throwable {
        Assert.assertEquals(int1, nota.getPrecoAluguel());
    }

    // @E("a data de entrega sera no dia seguinte")
// public void aDataDeEntregaSeraNoDiaSeguinte() throws Throwable {
//     Calendar cal = Calendar.getInstance();
//     cal.add(Calendar.DAY_OF_MONTH, 1);

//     Date dataRetorno = nota.getDataEntrega();
//     Calendar calRetorno = Calendar.getInstance();
//     calRetorno.setTime(dataRetorno);

//     Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
//     Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
//     Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
// }

    @E("o estoque do filme tera {int} unidade")
    public void oEstoqueDoFilmeTeraUnidade(int int1) throws Throwable {
        Assert.assertEquals(int1, filme.getEstoque());
    }

    @Entao("nao sera possivel por falta de estoque")
    public void naoSeraPossivelPorFaltaDeEstoque() {
        Assert.assertEquals("Filme sem estoque", erro);
    }

    @Dado("que o tipo do aluguel seja categoria {string}")
    public void queOTipoDoAluguelSeja(String tipo) {
         tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL : tipo.equals("extendido")
                 ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
    }

    @Entao("a data de entrega sera em {int} dia(s)")
    public void aDataDeEntregaSeraEmDias(int int1) {
        Date dataEsperada = DateUtils.obterDataComDiferencaDias(int1);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Entao("a pontuacao sera de {int} pontos")
    public void aPontuacaoSeraDePontos(int int1) {
        Assert.assertEquals(int1, nota.getPontuacao());
    }

    @Dado("um filme")
    public void umFilme(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
        filme = new Filme();
        filme.setEstoque(Integer.parseInt(map.get("estoque")));
        filme.setAluguel(Integer.parseInt(map.get("preco")));
        String tipo = map.get("tipo");
        tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL : tipo.equals("extendido")
                ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
    }
}
