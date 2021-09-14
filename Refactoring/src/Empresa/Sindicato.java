package Empresa;

import java.util.Scanner;

import Sistema.BaseDeDadosSingleton;
import Sistema.Excecoes;

public class Sindicato
{
    private BaseDeDadosSingleton basededados = BaseDeDadosSingleton.getInstance();
    private int numberSindicato;
    private double taxaSindical = 0;
    private double valorTaxaServico = 0;

    Scanner input = new Scanner(System.in);

    public boolean verifSindicato()
    {
        int index = basededados.procurarEmpregado();
        if (index == -1) return false;

        if (basededados.getEmpregadoArrayList().get(index).getIsSindicato() == 1)
        {
            return true;
        }
        else return false;
    }

    public void taxaServico()
    {
        System.out.print("\nDigite o serviço adicional prestado pelo sindicato:\n");
        String renderService = input.nextLine();

        System.out.println("\nValor da taxa de serviço: R$ ");
        double valor = Excecoes.readDouble();

        this.valorTaxaServico = valorTaxaServico + valor;

        System.out.println("\n============================Registro de Serviço=================================");
        System.out.println("Número do sindicato: " + numberSindicato);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Serviço: " + renderService + "		Valor do serviço: R$ " + valor);
        System.out.println("==================================================================================");

        System.out.println("\nTaxa de serviço registrada com sucesso!\n");

    }

    // GETTERS AND SETTERS

    public int getNumberSindicato()
    {
        return numberSindicato;
    }

    public void setNumberSindicato(int numberSindicato)
    {
        this.numberSindicato = numberSindicato;
    }

    public double getTaxaSindical()
    {
        return taxaSindical;
    }

    public void setTaxaSindical(double taxaSindical)
    {
        this.taxaSindical = taxaSindical;
    }

    public double getValorTaxaServico()
    {
        return valorTaxaServico;
    }

    public void setValorTaxaServico(double valorTaxaServico)
    {
        this.valorTaxaServico = valorTaxaServico;
    }
}
