package br.com.dio.desafio.models;

public class Gerente extends Funcionario{

    public Gerente(String nome, String senha) {
        super(nome, senha,8, 250d);
    }

    //escala 5x2
    @Override
    public void receberSalario() {
        int dias=getDiasTrabalhados();
        double salario=getSalarioDiario();
        if(getDiasTrabalhados()>20){
            System.out.println("Apto a receber "+(salario*20)+" reais");
            setDiasTrabalhados(0);
        }else {
            System.out.println("Apto a receber "+(salario*dias)+" reais");
        }
    }
}
