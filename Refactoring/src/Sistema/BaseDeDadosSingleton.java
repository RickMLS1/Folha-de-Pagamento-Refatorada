package Sistema;

import java.util.ArrayList;
import Empregado.Empregado;

public class BaseDeDadosSingleton
{
    private static BaseDeDadosSingleton uniqueInstance;
    private BaseDeDadosSingleton() {}

    private ArrayList<Empregado> empregadoArrayList = new ArrayList<>();

    public static synchronized BaseDeDadosSingleton getInstance()
    {

        if(uniqueInstance == null)
        {
            uniqueInstance = new BaseDeDadosSingleton();
        }
        return uniqueInstance;
    }

    public int procurarEmpregado()
    {
        int i;

        System.out.println("Digite o ID do Empregado:");
        int numberEmpregado = Excecoes.readInt();

        if (empregadoArrayList.isEmpty())
        {
            System.out.println("\nErro: Não há empregados cadastrados.\n");
            return -1;
        }

        for (i=0; i < empregadoArrayList.size(); i++)
        {
            if (empregadoArrayList.get(i).getNumberEmpregado() == numberEmpregado)
            {
                break;
            }
        }

        return i;
    }

    public void removerEmpregado()
    {
        System.out.println("\n\t**  	REMOVER FUNCIONÁRIO  	**\n");

        int index = procurarEmpregado();
        if (index == -1) return;

        System.out.println("\nRemovendo funcionário...");

        try
        {
            empregadoArrayList.remove(index);
            System.out.println("\nEmpregado removido com sucesso!\n");

        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("\nErro: Empregado não existe.\n");
        }
    }

    // GETTERS AND SETTERS

    public ArrayList<Empregado> getEmpregadoArrayList()
    {
        return empregadoArrayList;
    }

    public void setEmpregadoArrayList(Empregado empregado)
    {
        this.empregadoArrayList.add(empregado);
    }
}
