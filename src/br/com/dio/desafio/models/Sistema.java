package br.com.dio.desafio.models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import static java.lang.System.exit;

public class Sistema {

    private List<Funcionario> listaFuncionarios=new ArrayList<>();
    private LocalTime horarioAtual=LocalTime.now();
    private Scanner sc=new Scanner(System.in);

    public Sistema(){}

    public void cadastrarFuncionario(){
        System.out.println("");
        System.out.println("SISTEMA DE CADASTRAMENTO");
        System.out.println("");
        System.out.println("Digite o nome");
        String nome=sc.next();
        System.out.println("Digite a senha");
        String senha=sc.next();
        System.out.println("Digite o cargo");
        String cargo=sc.next();
        Funcionario funcionario = null;
        switch (cargo.toLowerCase()) {
            case "gerente":
                funcionario = new Gerente(nome, senha);
                break;
            case "estagiario":
                funcionario = new Estagiario(nome, senha);
                break;
            case "atendente":
                funcionario = new Atendente(nome, senha);
                break;
            default:
                System.out.println("Esse cargo nao esta registrado no nosso sistema");
                return;
        }
        Optional<Funcionario> funcionariocopia=listaFuncionarios.stream()
                .filter(f -> f.getNome().equals(nome)).findFirst();
        if(funcionariocopia.isEmpty()) {
            listaFuncionarios.add(funcionario);
            System.out.println("Funcionario cadastrado");
        }else{
            System.out.println("Esse funcionario ja existe no sistema");
        }

    }

    public void gerenciarFuncionario(){
        System.out.println("");
        System.out.println("Digite o nome");
        String nome=sc.next();
        System.out.println("Digite a senha");
        String senha=sc.next();
        Optional<Funcionario> funcionario=listaFuncionarios.stream()
                .filter(f -> f.getNome().equals(nome) && f.getSenha().equals(senha)).findFirst();
        if(funcionario.isPresent()){
            Funcionario funcionarioCopia=funcionario.get();
            System.out.println("");
            System.out.println("Qual operacao voce deseja realizar?");
            System.out.println("1-Iniciar jornada de trabalho");
            System.out.println("2-Encerrar jornada de trabalho");
            System.out.println("3-Verificar salario");
            int escolha=sc.nextInt();
            switch (escolha){
                case 1:
                    funcionarioCopia.iniciarJornada(horarioAtual);
                    break;

                case 2:
                    funcionarioCopia.terminarJornada(horarioAtual);
                    break;

                case 3:
                    funcionarioCopia.receberSalario();
                    break;

                default:
                    System.out.println("Operacao inexistente");
                    break;
            }
        }else{
            System.out.println("Este Funcionario nao foi encontrado");
        }
    }
}
