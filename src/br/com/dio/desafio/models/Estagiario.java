package br.com.dio.desafio.models;

public class Estagiario extends Funcionario{

    public Estagiario(String nome, String senha) {
        super(nome, senha, 6,100d);
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
