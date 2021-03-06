package Empregado;

import Sistema.BaseDeDadosSingleton;
import Sistema.Excecoes;

public class CartaoPonto
{
    private BaseDeDadosSingleton basededados = BaseDeDadosSingleton.getInstance();
    private Horista horista;

    public boolean verifHorista()
    {
        int index = basededados.procurarEmpregado();
        if (index == -1) return false;

        if (basededados.getEmpregadoArrayList().get(index) instanceof Horista)
        {
            horista = (Horista) basededados.getEmpregadoArrayList().get(index);

            return true;
        }
        else return false;
    }

    public void playCartaoPonto()
    {
        if (verifHorista() == true)
        {
            System.out.println("\nHorário Entrada:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
            int cartaoPontoE = Excecoes.readInt();

            System.out.println("\nHorário Saída:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
            int cartaoPontoS = Excecoes.readInt();

            // Calcula o salário

            double salarioHorista = horista.getSalarioHorista() + (calcularSalario(horista.getSalarioHora(), cartaoPontoE, cartaoPontoS));

            horista.setSalarioHorista(salarioHorista);

            System.out.println("\nCartão de Ponto registrado com sucesso!\n");
        }
        else {System.out.println("\nErro: Empregado não é Horista.\n");}
    }

    public double calcularSalario (double salarioHora, int entrada, int saida)
    {
        double salario;

        int horaTrabalhada = saida - entrada;
        float minutos = horaTrabalhada % 100;

        if (horaTrabalhada <= 800)
        {
            if (minutos < 10)
            {
                minutos = minutos / 10;
            }
            else
            {
                minutos = minutos / 100;
            }

            salario = ((horaTrabalhada / 100) * salarioHora) + (minutos * horaTrabalhada);
        }
        else
        {
            int horaExtra = horaTrabalhada - 800;

            if (minutos < 10)
            {
                minutos = minutos / 10;
            }
            else
            {
                minutos = minutos / 100;
            }

            salario = (8 * salarioHora + ((horaExtra / 100) * (salarioHora * 1.5)) + (minutos * (horaExtra * 1.5)));
        }

        return salario;
    }

}
