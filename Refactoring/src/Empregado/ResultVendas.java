package Empregado;

import Sistema.BaseDeDadosSingleton;
import Sistema.Excecoes;

public class ResultVendas
{
    private BaseDeDadosSingleton basededados = BaseDeDadosSingleton.getInstance();
    private Comissionado comissionado;

    public boolean verifComissionado()
    {
        int index = basededados.procurarEmpregado();
        if (index == -1) return false;

        if (basededados.getEmpregadoArrayList().get(index) instanceof Comissionado)
        {
            comissionado = (Comissionado) basededados.getEmpregadoArrayList().get(index);

            return true;
        }
        else return false;
    }
    public void playResultVendas()
    {
        if (verifComissionado() == true)
        {
            System.out.println("\nDia da venda:");
            int vendaDiaria = Excecoes.readInt();

            System.out.println("\nMês da venda:");
            int vendaMensal = Excecoes.readInt();

            System.out.println("\nAno da venda:");
            int vendaAnual = Excecoes.readInt();

            System.out.print("\nValor da venda:\nExemplo: 1500 - 3000.56\nR$ ");
            double valorVenda = Excecoes.readDouble();

            comissionado.setValorComissao((valorVenda * comissionado.getComissao())/100);

            System.out.println("\n===============================Registro de Venda=================================");
            System.out.println("Nome: " + comissionado.getNome() + "		Número do empregado: " + comissionado.getNumberEmpregado());
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Data da venda: " + vendaDiaria + "/ " + vendaMensal + "/" + vendaAnual + "		Valor da comissão: R$ " + ((valorVenda * comissionado.getComissao())/100));
            System.out.println("==================================================================================");

            System.out.println("\nResultado da venda registrado com sucesso!\n");
        }
        else
        {
            System.out.println("\nErro: Empregado não é comissionado.\n");
        }
    }
}
