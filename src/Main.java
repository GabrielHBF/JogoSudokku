import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro();

       Scanner input = new Scanner(System.in);
       int continuar = 1;
       do{
           System.out.println("Digite o numero da linha: ");
           int numeroLinhas = input.nextInt();
           System.out.println("Digite o numero da coluna: ");
           int numeroColunas = input.nextInt();
           System.out.println("Digite o numero que deseja inserir: ");
           int numeroAMudar = input.nextInt();

           tabuleiro.setTabuleiro(numeroLinhas, numeroColunas, numeroAMudar);

           tabuleiro.ImprimirTabuleiro();
           System.out.println("Deseja continuar digite 1 ou 2 para sair");
           continuar = input.nextInt();
       }while (continuar == 1);
 }
}