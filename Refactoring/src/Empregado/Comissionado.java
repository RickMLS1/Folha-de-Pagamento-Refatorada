package Empregado;

import java.util.ArrayList;
import Sistema.Excecoes;

public class Comissionado extends Empregado // Hierarquia (extends)
{
    public Comissionado(int numberEmpregado, String nome, String endereco, int tipo, int metododePagamento, int isSindicato, String tipoCronograma, int diaSemana)
    {
        super(numberEmpregado, nome, endereco, tipo, metododePagamento, isSindicato, tipoCronograma, diaSemana);
    }

    private double salarioFixoComissionado;
    private double salarioLiqComissionado;
    private double valorComissao;
    private double comissao;

    // PADRÃO DE PROJETO : TEMPLATE METHOD

    @Override
    public void salarioEntrada()
    {
        System.out.print("\nInforme o salário:\nExemplo: 1500 - 3000,56\nR$ ");

        double salarioTemp = Excecoes.readDouble();

        System.out.println("\nInforme o percentual de comissão:\nExemplo: 15 para 15% 1.5 para 1.5%");
        this.comissao = Excecoes.readDouble();

        this.salarioFixoComissionado = salarioTemp;
    }

    @Override
    public void pagarEmpregado(ArrayList<Empregado> empregado, int index)
    {
        this.salarioLiqComissionado = salarioFixoComissionado + valorComissao - getSindicato().getTaxaSindical() - getSindicato().getValorTaxaServico();
        System.out.println(empregado.get(index).toString() + "\n");

        this.salarioLiqComissionado = 0;
        this.valorComissao = 0;
    }

    // GETTERS AND SETTERS

    public double getSalarioFixoComissionado()
    {
        return salarioFixoComissionado;
    }

    public double getSalarioLiqComissionado()
    {
        return salarioLiqComissionado;
    }

    public double getComissao()
    {
        return comissao;
    }

    public double getValorComissao()
    {
        return valorComissao;
    }

    public void setValorComissao(double valorComissao)
    {
        this.valorComissao = valorComissao;
    }

    @Override
    public String toString()
    {
        String string, diaString = null;

        string = super.toString();

        string += "Tipo: Comissionado		Salário Bruto: R$ " + this.salarioFixoComissionado + "	Comissão: " + this.comissao + "%";
        string += "\n--------------------------------------------------------------------------------------------------------\n";

        if (getFreqDiaria() == 1) diaString = "Segunda";
        else if (getFreqDiaria() == 2) diaString = "Terça";
        else if (getFreqDiaria() == 3) diaString = "Quarta";
        else if (getFreqDiaria() == 4) diaString = "Quinta";
        else if (getFreqDiaria() == 5) diaString = "Sexta";
        else if (getFreqDiaria() == 6) diaString = "Sábado";
        else if (getFreqDiaria() == 7) diaString = "Domingo";

        string += "Agenda de Pagamento: " + getTipoCronograma() + "	Dia da semana: " + diaString;
        string += "\n_________________________________________________________________________________________________________\n";

        if (getIsSindicato() == 1)
        {
            string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicato().getTaxaSindical();
            string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicato().getValorTaxaServico();
        }

        string += "\nComissão de vendas -------------------------------------------------------- (+) R$ " + this.valorComissao;
        string += "\n\nSalário Líquido  -------------------------------------------------------------- R$ " + this.salarioLiqComissionado;

        return string;
    }

}
