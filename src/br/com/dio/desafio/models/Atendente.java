package br.com.dio.desafio.models;

public class Atendente extends Funcionario{

    public Atendente(String nome, String senha) {
        super(nome, senha, 12, 125d);
    }

    //escala 6x1
    @Override
    public void receberSalario() {
        int dias=getDiasTrabalhados();
        double salario=getSalarioDiario();
        if(getDiasTrabalhados()>24){
            System.out.println("Apto a receber "+(salario*24)+" reais");
            setDiasTrabalhados(0);
        }else {
            System.out.println("Apto a receber "+(salario*dias)+" reais");
        }
    }
}
