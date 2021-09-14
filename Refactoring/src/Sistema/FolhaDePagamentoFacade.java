package Sistema;

import Empresa.AddEmpregado;
import Empregado.CartaoPonto;
import Empregado.ResultVendas;
import Empresa.Cronograma;
import Empresa.PlayFolhadePagamento;

public class FolhaDePagamentoFacade
{
    private BaseDeDadosSingleton basededados;
    private AddEmpregado addEmpregado;
    private CartaoPonto cartaoPonto;
    private ResultVendas resultVenda;
    private PlayFolhadePagamento playFolhadePagamento;
    private Cronograma cronograma;

    public FolhaDePagamentoFacade()
    {
        this.basededados = BaseDeDadosSingleton.getInstance();
        this.addEmpregado = new AddEmpregado();
        this.cartaoPonto = new CartaoPonto();
        this.resultVenda = new ResultVendas();
        this.playFolhadePagamento = new PlayFolhadePagamento();
        this.cronograma = new Cronograma();
    }

    public void add()
    {
        addEmpregado.add();
    }

    public void remover()
    {
        basededados.removerEmpregado();
    }

    public void cartaoPonto()
    {
        cartaoPonto.playCartaoPonto();
    }

    public void venda()
    {
        resultVenda.playResultVendas();
    }

    public void taxaServico()
    {
        int index = basededados.procurarEmpregado();
        if (index == -1) return;

        if (basededados.getEmpregadoArrayList().get(index).getIsSindicato() == 1)
        {
            basededados.getEmpregadoArrayList().get(index).getSindicato().taxaServico();
        }
        else
        {
            System.out.println("\nErro: Empregado não pertence ao sindicato.\n");
        }
    }
    public void editar()
    {
        int index = basededados.procurarEmpregado();
        if (index == -1) return;

        basededados.getEmpregadoArrayList().get(index).alterarDetalhes();
    }

    public void play(int dia, int diaSemana, int semana, int ultimo)
    {
        playFolhadePagamento.playFolhadePagamento(dia, diaSemana, semana, ultimo);
    }
    public void calendarioPagamento()
    {
        cronograma.consultaCronograma();
    }
    public void novoCalendario()
    {
        cronograma.novoCalendario();
    }
}

