package services;

import entidades.Filme;
import entidades.NotaAluguel;
import entidades.TipoAluguel;
import utils.DateUtils;


public class AluguelService {

    public NotaAluguel alugar(Filme filme, TipoAluguel tipo) {
        if(filme.getEstoque() == 0) throw new RuntimeException("Filme sem estoque");

        NotaAluguel nota = new NotaAluguel();

        switch (tipo) {
            case COMUM:
                nota.setPrecoAluguel(filme.getAluguel());
                nota.setDataEntrega(DateUtils.obterDataComDiferencaDias(1));
                nota.setPontuacao(1);
                break;
            case SEMANAL:
                nota.setPrecoAluguel(filme.getAluguel() * 3);
                nota.setDataEntrega(DateUtils.obterDataComDiferencaDias(7));
                nota.setPontuacao(3);
                break;
            case EXTENDIDO:
                nota.setPrecoAluguel(filme.getAluguel() * 2);
                nota.setDataEntrega(DateUtils.obterDataComDiferencaDias(3));
                nota.setPontuacao(2);
                break;
        }

        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
