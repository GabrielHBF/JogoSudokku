import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Random;

public class Tabuleiro {

    private int[][] tabuleiro;
    private int[][] ValoresFixos;

    //Tabulerio com tamanho fixo de 3 por 3
    Tabuleiro() {
       this.tabuleiro = new int[9][9];
       this.ValoresFixos = new int[9][9];
        AleatorioTabuleiro();
        ImprimirTabuleiro();
    }
    // função para imprimir o tabuleiro
    public void ImprimirTabuleiro() {

        System.out.println("| |=0=1=2=||=3=4=5=||=6=7=8=||");
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            System.out.print("|" + linha + "| ");
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                System.out.print(tabuleiro[linha][coluna] + " ");
                if ((coluna + 1) % 3 == 0 ) {
                    System.out.print("|| ");
                }
            }
            System.out.println();
            if ((linha + 1) % 3 == 0) {
                System.out.println("| |=======||=======||=======||");
            }
        }
    }
    public void setTabuleiro(int indiceLinha, int indiceColuna,int valorAsubstituir ) {
        if(ValoresFixos[indiceLinha][indiceColuna] == valorAsubstituir) {
            System.out.println("Esse Valor Não Pode ser Substituidor");
        }else if(ValidarTabuleiro(valorAsubstituir)){
            this.tabuleiro[indiceLinha][indiceColuna] = valorAsubstituir;
        }else {
            System.out.println("Esse Valor Não Pode ser inserido verifique a linha e coluna");
        }
    }
    //Adiciona Numeros ao Tabuleiro
    private int[][] AleatorioTabuleiro() {

        Random random = new Random();
        for (int i = 0; i < tabuleiro.length; i++) {
            int numeroLinha = random.nextInt(9);
            int numeroColuna = random.nextInt(9);
            int valorAsubstituir = random.nextInt(9) + 1;

            if(ValidarTabuleiro(valorAsubstituir())) {
                this.tabuleiro[numeroLinha][numeroColuna] = valorAsubstituir;
                for (int cont = 0; cont < 9; cont++) {
                    System.arraycopy(this.tabuleiro[cont], 0, this.ValoresFixos[cont], 0, 9);
                }
            }
        }
        return this.tabuleiro;
    }

        private boolean ValidarTabuleiro (int linha,int coluna, int numero){
            for (int i = 0; i < 9; i++) {
                    if (this.tabuleiro[linha][i] == numero && this.tabuleiro[i][coluna] == linha) {
                        return true;
                    }else {
                        return false;
                }
            }
            return true;
        }
    }


