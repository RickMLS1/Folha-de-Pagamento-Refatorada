package Empregado;

import java.util.ArrayList;
import Sistema.Excecoes;

public class Horista extends Empregado // Hierarquia (extends)
{
    public Horista (int numberEmpregado, String nome, String endereco, int tipo, int metododePagamento, int isSindicato, String tipoCronograma, int diaSemana)
    {
        super(numberEmpregado, nome, endereco, tipo, metododePagamento, isSindicato, tipoCronograma, diaSemana);
    }

    private double salarioLiqHorista = 0;
    private double salarioHorista = 0;
    private double salarioHora = 0;

    // PADRÃO DE PROJETO : TEMPLATE METHOD

    @Override
    public void salarioEntrada()
    {
        System.out.print("\nInforme o salário por hora trabalhada:\nExemplo: 1,5 - 3\nR$ ");

        double salarioTemp = Excecoes.readDouble();

        this.salarioHora = salarioTemp;
    }

    @Override
    public void pagarEmpregado(ArrayList<Empregado> empregado, int index)
    {
        this.salarioLiqHorista = salarioHorista - getSindicato().getTaxaSindical() - getSindicato().getValorTaxaServico();
        System.out.println(empregado.get(index).toString() + "\n");

        this.salarioLiqHorista = 0;
        this.salarioHorista = 0;
    }

    // GETTERS AND SETTERS

    public double getSalarioLiqHorista()
    {
        return salarioLiqHorista;
    }

    public void setSalarioLiqHorista(double salarioLiqHorista)
    {
        this.salarioLiqHorista = salarioLiqHorista;
    }

    public double getSalarioHorista()
    {
        return salarioHorista;
    }

    public void setSalarioHorista (double salarioHorista)
    {
        this.salarioHorista  = salarioHorista;
    }

    public double getSalarioHora()
    {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora)
    {
        this.salarioHora = salarioHora;
    }

    @Override
    public String toString()
    {
        String string, diaString = null;

        string = super.toString();

        string += "Tipo: Horista		Salário Hora: R$ " + this.salarioHora;
        string += "\n--------------------------------------------------------------------------------------------------------\n";

        if (getFreqDiaria() == 1) diaString = "Segunda";
        else if (getFreqDiaria() == 2) diaString = "Terça";
        else if (getFreqDiaria() == 3) diaString = "Quarta";
        else if (getFreqDiaria() == 4) diaString = "Quinta";
        else if (getFreqDiaria() == 5) diaString = "Sexta";
        else if (getFreqDiaria() == 6) diaString = "Sábado";
        else if (getFreqDiaria() == 7) diaString = "Domingo";

        string += "Agenda de Pagamento: " + this.getTipoCronograma() + "	Dia da semana: " + diaString;
        string += "\n________________________________________________________________________________________________________\n";

        if (getIsSindicato() == 1)
        {
            string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicato().getTaxaSindical();
            string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicato().getValorTaxaServico();
        }

        string += "\nSalário  Bruto Acumulado -------------------------------------------------- (+) R$ " + this.salarioHorista;
        string += "\n\nSalário Líquido --------------------------------------------------------------- R$ " + this.salarioLiqHorista;

        return string;
    }

}
