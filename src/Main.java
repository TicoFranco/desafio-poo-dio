import br.com.dio.desafio.models.Sistema;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       boolean desativar=false;
       Scanner sc=new Scanner(System.in);
       Sistema sistema=new Sistema();
       try {
           while (!desativar) {
               System.out.println("");
               System.out.println("SISTEMA- Qual Operacao e desejada?");
               System.out.println("1-Cadastrar Funcionario");
               System.out.println("2-Gerenciar Funcionario(jornada de trabalho e salario)");
               System.out.println("digite outro numero caso queira encerrar a sessao");
               int opcao = sc.nextInt();
               switch (opcao) {
                   case 1:
                       sistema.cadastrarFuncionario();
                       break;

                   case 2:
                       sistema.gerenciarFuncionario();
                       break;

                   default:
                       System.out.println("Fim");
                       desativar = true;
                       break;
               }
           }
       }catch (InputMismatchException e){
           System.out.println("O Tipo de dado fornecido esta incorreto");
       }
    }
}