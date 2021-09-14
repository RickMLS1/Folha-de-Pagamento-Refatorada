package Empresa;

import java.util.ArrayList;

import Empregado.Empregado;
import Sistema.BaseDeDadosSingleton;

public class PlayFolhadePagamento
{
    private BaseDeDadosSingleton basededados = BaseDeDadosSingleton.getInstance();
    private ArrayList<Empregado> empregadoArrayList = basededados.getEmpregadoArrayList();

    public void playFolhadePagamento(int dia, int diaSemana, int semana, int ultimo)
    {
        System.out.println("\n**  	RODAR A FOLHA DE PAGAMENTO  	**\n");
        System.out.println("Verificando Empregados...\n");

        for (int i = 0; i < empregadoArrayList.size(); i++)
        {
            if ((empregadoArrayList.get(i).getTipoCronograma() == "1 - Semanal") && (empregadoArrayList.get(i).getFreqDiaria() == diaSemana))
            {
                empregadoArrayList.get(i).pagarEmpregado(empregadoArrayList, i);
            }

            else if ((empregadoArrayList.get(i).getTipoCronograma() == "2 - Semanal") && (empregadoArrayList.get(i).getFreqDiaria() == diaSemana) && (semana == 2 || semana == 4))
            {
                empregadoArrayList.get(i).pagarEmpregado(empregadoArrayList, i);
            }

            else if ((empregadoArrayList.get(i).getTipoCronograma() == "3 - Semanal") && (empregadoArrayList.get(i).getFreqDiaria() == diaSemana) && (semana == 3))
            {
                empregadoArrayList.get(i).pagarEmpregado(empregadoArrayList, i);
            }

            else if (empregadoArrayList.get(i).getTipoCronograma() == "Mensal")
            {
                if (empregadoArrayList.get(i).getFreqDiaria() == 28 || empregadoArrayList.get(i).getFreqDiaria() == 30 || empregadoArrayList.get(i).getFreqDiaria() == 31)
                {
                    //Verifica se o dia na agenda não foi alterado

                    empregadoArrayList.get(i).setFreqDiaria(ultimo);
                }
                if (empregadoArrayList.get(i).getFreqDiaria() == dia)
                {
                    empregadoArrayList.get(i).pagarEmpregado(empregadoArrayList, i);
                }
            }
        }
    }
}
