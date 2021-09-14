package Empresa;

import java.util.ArrayList;

import Empregado.Empregado;
import Sistema.BaseDeDadosSingleton;
import Sistema.Excecoes;

public class Cronograma
{
    private BaseDeDadosSingleton basededados = BaseDeDadosSingleton.getInstance();
    private ArrayList<Empregado> empregadoArrayList = basededados.getEmpregadoArrayList();

    public void consultaCronograma()
    {
        if (empregadoArrayList.isEmpty())
        {
            System.out.println("\nErro: Não há empregados cadastrados.\n");
            return;
        }

        for (int i=0; i < empregadoArrayList.size(); i++)
        {
            System.out.println(empregadoArrayList.get(i).toString() + "\n\n");
        }
    }
    public void novoCalendario()
    {
        int index = basededados.procurarEmpregado();

        String schedule = null;

        System.out.println("\nEscolha uma opção:\n(1) - Mensal\n(2) - Semanal");
        int option = Excecoes.readInt();

        if (option == 1)
        {
            System.out.println("\nEscolha o dia ou digite -1 para o último dia do mês");
            int option2 = Excecoes.readInt();

            empregadoArrayList.get(index).setTipoCronograma("Mensal");

            if (option2 == -1)
            {
                empregadoArrayList.get(index).setFreqDiaria(30);
            }
            else
            {
                empregadoArrayList.get(index).setFreqDiaria(option2);
            }
        }
        else if (option == 2)
        {
            System.out.println("\nEscolha a frequencia:\n1 - Toda semana\n2 - A cada duas semanas\n3 - A cada três semanas\n");
            int option2 = Excecoes.readInt();

            if (option2 == 1) schedule = "1 - Semanal";
            else if (option2 == 2) schedule = "2 - Semanal";
            else if (option2 == 3) schedule = "3 - Semanal";

            empregadoArrayList.get(index).setTipoCronograma(schedule);

            System.out.println("\nEscolha o dia da semana:\n1 - Segunda\n2 - Terça\n3 - Quarta\n4 - Quinta\n5 - Sexta");
            int option3 = Excecoes.readInt();

            empregadoArrayList.get(index).setFreqDiaria(option3);
        }
        System.out.println("\nNova agenda de pagamento criada com sucesso!\n");
    }
}
