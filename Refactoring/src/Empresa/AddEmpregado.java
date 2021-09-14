package Empresa;

import java.util.Scanner;

import Empregado.Assalariado;
import Empregado.Comissionado;
import Empregado.Horista;
import Sistema.BaseDeDadosSingleton;
import Sistema.Excecoes;

public class AddEmpregado
{
    private BaseDeDadosSingleton basededados;
    private Horista horista;
    private Assalariado assalariado;
    private Comissionado comissionado;

    static private int numberSindicato = 1;
    static private int numberEmpregado = 1;

    Scanner input = new Scanner(System.in);

    public void add()
    {
        basededados = BaseDeDadosSingleton.getInstance();
        double taxaSindical = 0.0;

        System.out.println("\n**  ADICIONAR EMPREGADO  **\n");

        System.out.println("Digite o nome do empregado:");
        String nome = input.nextLine();

        System.out.println("\nDigite o endereço do empregado:");
        String endereco = input.nextLine();

        System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
        int metododePagamento = Excecoes.readInt();

        System.out.println("\nPertence ao sindicato?\n(1) - Sim\n(0) - Não");
        int isSindicato = Excecoes.readInt();

        if (isSindicato == 1) {
            System.out.print("Digite o valor da taxa sindical:\nR$ ");
            taxaSindical = Excecoes.readDouble();
        }

        System.out.println("\nEscolha o tipo do empregado:\n(1) - Horista\n(2) - Assalariado\n(3) - Comissionado");
        int tipo = Excecoes.readInt();

        if (tipo == 1)
        {
            horista = new Horista(numberEmpregado, nome, endereco, metododePagamento, isSindicato, tipo, "1 - Semanal", 5);

            horista.salarioEntrada();

            if (isSindicato == 1)
            {
                horista.getSindicato().setNumberSindicato(numberSindicato);
                horista.getSindicato().setTaxaSindical(taxaSindical);
                numberSindicato++;
            }

            basededados.setEmpregadoArrayList(horista);

        }
        else if (tipo == 2)
        {
            assalariado = new Assalariado(numberEmpregado, nome, endereco, metododePagamento, isSindicato, tipo, "Mensal", 31);

            assalariado.salarioEntrada();

            if (isSindicato == 1)
            {
                assalariado.getSindicato().setNumberSindicato(numberSindicato);
                assalariado.getSindicato().setTaxaSindical(taxaSindical);
                numberSindicato++;
            }

            basededados.setEmpregadoArrayList(assalariado);

        }
        else if (tipo == 3)
        {
            comissionado = new Comissionado(numberEmpregado, nome, endereco, metododePagamento, isSindicato, tipo, "2 - Semanal", 5);
            comissionado.salarioEntrada();

            if (isSindicato == 1)
            {
                comissionado.getSindicato().setNumberSindicato(numberSindicato);
                comissionado.getSindicato().setTaxaSindical(taxaSindical);
                numberSindicato++;
            }
            basededados.setEmpregadoArrayList(comissionado);
        }
        else
        {
            System.out.println("\nErro: Opção Inválida.\n");
        }
        System.out.println("\nEmpregado cadastrado com sucesso!\n");
        numberEmpregado++;
    }
}
