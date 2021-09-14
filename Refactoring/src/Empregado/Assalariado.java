package Empregado;

import Sistema.Excecoes;
import java.util.ArrayList;

public class Assalariado extends Empregado // Hierarquia (extends)
{
    public Assalariado (int numberEmpregado, String nome, String endereco, int tipo, int metododePagamento, int isSindicato, String tipoCronograma, int diaSemana)
    {
        super(numberEmpregado, nome, endereco, tipo, metododePagamento, isSindicato, tipoCronograma, diaSemana);
    }

    // SALARIO

    private double salarioFixAssalariado;
    private double salarioLiqAssalariado;

    // PADRÃO DE PROJETO : TEMPLATE METHOD

    @Override
    public void salarioEntrada() {
        System.out.print("\nInforme o salário fixo mensal:\nExemplo: 1500 - 3000,56\nR$ ");

        double salarioTemp = Excecoes.readDouble();

        this.salarioFixAssalariado = salarioTemp;
    }

    @Override
    public void pagarEmpregado(ArrayList<Empregado> empregado, int index) {
        this.salarioLiqAssalariado = salarioFixAssalariado - getSindicato().getTaxaSindical() - getSindicato().getValorTaxaServico();
        System.out.println(empregado.get(index).toString() + "\n");

        this.salarioLiqAssalariado = 0;
    }

    // GETTERS AND SETTERS

    public double getSalarioFixAssalariado()
    {
        return salarioFixAssalariado;
    }

    public double getSalarioLiqAssalariado()
    {
        return salarioLiqAssalariado;
    }

    @Override
    public String toString() {
        String string;

        string = super.toString();

        string += "Tipo: Assalariado		Salário Bruto: R$ " + this.salarioFixAssalariado;
        string += "\n--------------------------------------------------------------------------------------------------------\n";
        string += "Agenda de Pagamento: " + this.getTipoCronograma() + "	Dia: " + this.getFreqDiaria();
        string += "\n________________________________________________________________________________________________________\n\n";
        if (getIsSindicato() == 1) {
            string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicato().getTaxaSindical();
            string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicato().getValorTaxaServico();
        }
        string += "\n\nSalário Líquido --------------------------------------------------------------- R$ " + this.salarioLiqAssalariado;

        return string;
    }
}
