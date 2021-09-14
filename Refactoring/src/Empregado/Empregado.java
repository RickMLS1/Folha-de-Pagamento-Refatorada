package Empregado;

import java.util.ArrayList;
import java.util.Scanner;
import Empresa.Sindicato;
import Sistema.Excecoes;

public abstract class Empregado
{
    private int numberEmpregado;
    private String nome;
    private String endereco;
    private int tipo;
    private int metododePagamento;
    private int isSindicato = 0;
    private String tipoCronograma;
    private int freqDiaria;

    Sindicato sindicato = new Sindicato();

    public Empregado(int numberEmpregado, String nome, String endereco, int tipo, int metododePagamento, int isSindicato, String tipoCronograma, int diaSemana)
    {
        this.numberEmpregado = numberEmpregado;
        this.nome = nome;
        this.endereco = endereco;
        this.tipo = tipo;
        this.metododePagamento = metododePagamento;
        this.isSindicato = isSindicato;
        this.tipoCronograma = tipoCronograma;
        this.freqDiaria = diaSemana;
    }

    Scanner input = new Scanner(System.in);

    // PADRÃO DE PROJETO : TEMPLATE METHOD

    public abstract void salarioEntrada();
    public abstract void pagarEmpregado(ArrayList<Empregado> empregado, int index);

    public void alterarDetalhes()
    {
        System.out.println("\n**  	ALTERAR DETALHES DO EMPREGADO  	**\n");
        System.out.println("Escolha uma opção:");
        System.out.println("(1) - Alterar Nome");
        System.out.println("(2) - Alterar Endereço");
        System.out.println("(3) - Alterar Método de Pagamento");
        System.out.println("(4) - Alterar Sindicato");
        System.out.println("(5) - Alterar Tipo");

        int option = Excecoes.readInt();

        switch(option)
        {
            case 1:
                System.out.println("Digite o nome do empregado:");
                String nome = input.nextLine();

                setNome(nome);

                System.out.println("\nNome do empregado alterado com sucesso!\n");

                break;

            case 2:
                System.out.println("\nDigite o endereço do empregado:");
                String endereco = input.nextLine();

                setEndereco(endereco);

                System.out.println("\nEndereço do empregado alterado com sucesso!\n");

                break;

            case 3:
                System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
                int metododePagamento = Excecoes.readInt();

                setMetododePagamento(metododePagamento);

                System.out.println("\nMétodo de pagamento do empregado alterado com sucesso!\n");

                break;

            case 4:
                System.out.println("\nPertence ao sindicato?\n(1) - Sim\n(0) - Não");
                int isSindicato = Excecoes.readInt();

                setIsSindicato(isSindicato);

                if (isSindicato == 1)
                {
                    System.out.print("Digite o valor da taxa sindical:\nR$ ");
                    double taxaSindical = Excecoes.readDouble();

                    sindicato.setNumberSindicato(getNumberEmpregado());
                    sindicato.setTaxaSindical(taxaSindical);

                    setNumberEmpregado(getNumberEmpregado() + 1);
                }

                System.out.println("\nSindicato do empregado alterado com sucesso!\n");

                break;
        }
    }

    // GETTERS AND SETTERS

    public int getNumberEmpregado()
    {
        return this.numberEmpregado;
    }

    public void setNumberEmpregado(int numberEmpregado)
    {
        this.numberEmpregado = numberEmpregado;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEndereco()
    {
        return this.endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public int getTipo()
    {
        return this.tipo;
    }

    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }

    public int getMetododePagamento()
    {
        return this.metododePagamento;
    }

    public void setMetododePagamento(int metododePagamento)
    {
        this.metododePagamento = metododePagamento;
    }

    public int getIsSindicato()
    {
        return this.isSindicato;
    }

    public void setIsSindicato(int IsSindicato)
    {
        this.isSindicato = IsSindicato;
    }

    public Sindicato getSindicato()
    {
        return sindicato;
    }

    public void setSindicato(Sindicato sindicato)
    {
        this.sindicato = sindicato;
    }

    public String getTipoCronograma()
    {
        return tipoCronograma;
    }

    public void setTipoCronograma(String tipoCronograma)
    {
        this.tipoCronograma = tipoCronograma;
    }

    public int getFreqDiaria()
    {
        return freqDiaria;
    }

    public void setFreqDiaria(int freqDiaria)
    {
        this.freqDiaria = freqDiaria;
    }

    @Override
    public String toString()
    {
        String string;

        string = "ID Empregado: " + this.numberEmpregado + "		Nome: " + this.nome;
        string += "\n--------------------------------------------------------------------------------------------------------\n";
        string += "Endereço: " + this.endereco;
        string += "\n--------------------------------------------------------------------------------------------------------\n";

        if (this.metododePagamento == 1)
        {
            string += "Método de Pagamento: Cheque pelos correios";
        }
        else if (this.metododePagamento == 2)
        {
            string += "Método de Pagamento: Cheque em mãos";
        }
        else if (this.metododePagamento == 3)
        {
            string += "Método de Pagamento: Depósito em conta bancária";
        }

        string += "\n--------------------------------------------------------------------------------------------------------\n";

        if (isSindicato == 1)
        {
            string += "Sindicado: Pertence		Número do Sindicato: " + this.sindicato.getNumberSindicato() + "		Taxa Sindical: R$ " + this.sindicato.getTaxaSindical();
        }
        else
        {
            string += "Sindicado: Não Pertence";
        }

        string += "\n--------------------------------------------------------------------------------------------------------\n";

        return string;
    }
}
