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

    //entrada de dados do usuario verifica se esses numero ja estao colocados ou se sao os nao subistituiveis
    public void setTabuleiro(int indiceLinha, int indiceColuna,int valorAsubstituir ) {

        if(ValoresFixos[indiceLinha][indiceColuna] == valorAsubstituir) {
            System.out.println("Esse Valor Não Pode ser Substituidor");
        }else if(ValidarTabuleiro(indiceLinha,indiceColuna,valorAsubstituir)){
            this.tabuleiro[indiceLinha][indiceColuna] = valorAsubstituir;
        }else {
            System.out.println("Esse Valor Não Pode ser inserido verifique a linha e coluna");
        }
    }
    //Adiciona Numeros ao Tabuleiro
    private void AleatorioTabuleiro() {

        Random random = new Random();
        for (int i = 0; i < tabuleiro.length; i++) {
            int numeroLinha = random.nextInt(9);
            int numeroColuna = random.nextInt(9);
            int valorAsubstituir = random.nextInt(9) + 1;

    //chama o metodo para verificar os numero e cria uma copia do array

            if(ValidarTabuleiro(numeroLinha,numeroColuna,valorAsubstituir)) {
                this.tabuleiro[numeroLinha][numeroColuna] = valorAsubstituir;
                for (int cont = 0; cont < 9; cont++) {
                    System.arraycopy(this.tabuleiro[cont], 0, this.ValoresFixos[cont], 0, 9);
                }
            }
        }
    }
//metodo para verificar se o numero esta na linha ou coluna se estiver ele retorna true

       private boolean ValidarTabuleiro (int linha,int coluna, int numero){
            for (int i = 0; i < 9; i++) {
                    if (validarBloco(linha,coluna,numero)) {
                        if(this.tabuleiro[linha][i] == numero || this.tabuleiro[i][coluna] == numero) {
                            return false;
                        }
                    }else {
                        return true;
                }
            }
            return false;
        }

    private boolean validarBloco(int linha, int coluna, int numero){
        boolean verdadeiro = false;
        switch (linha) {
            case 0,1,2 : switch (coluna) {
                             case 0,1,2 :
                                 int i = 3;
                                 for (int  j  = 0; j < i; j++) {
                                     if (this.tabuleiro[linha][j] == numero || this.tabuleiro[j][coluna] == numero) {
                                         verdadeiro = true;
                                     }
                                 }
                             case 3,4,5 :
                                 int ii = 6;
                                 for (int j = 3 ;j < ii; j++) {
                                     if (this.tabuleiro[linha][j] == numero || this.tabuleiro[j][coluna] == numero) {
                                         verdadeiro = true;
                                     }
                                 }
                                case 6,7,8:
                                    int iii = 9;
                                    for (int j = 6 ;j < iii; j++) {
                                        if (this.tabuleiro[linha][j] == numero || this.tabuleiro[j][coluna] == numero) {
                                            verdadeiro = true;
                                        }
                                    }
            }
            case 3,4,5 : switch (coluna) {
                         case 0,1,2 :
                             int i = 3;
                             for (int  j  = 0; j < i; j++) {
                                 if (this.tabuleiro[linha][j] == numero || this.tabuleiro[j][coluna] == numero) {
                                     verdadeiro = true;
                                 }
                             }
                            case 3,4,5 :
                                int ii = 6;
                                for (int j = 3 ;j < ii; j++) {
                                    if (this.tabuleiro[linha][j] == numero || this.tabuleiro[j][coluna] == numero) {
                                        verdadeiro = true;
                                    }
                                }
                               case 6,7,8:
                                   int iii = 9;
                                   for (int j = 6 ;j < iii; j++) {
                                       if (this.tabuleiro[linha][j] == numero || this.tabuleiro[j][coluna] == numero) {
                                           verdadeiro = true;
                                       }
                                   }
            }
            case 6,7,8 : switch (coluna) {
                case 0,1,2 :
                    int i = 3;
                    for (int  j  = 0; j < i; j++) {
                        if (this.tabuleiro[linha][j] == numero || this.tabuleiro[j][coluna] == numero) {
                            verdadeiro = true;
                        }
                    }
                case 3,4,5 :
                    int ii = 6;
                    for (int j = 3 ;j < ii; j++) {
                        if (this.tabuleiro[linha][j] == numero || this.tabuleiro[j][coluna] == numero) {
                            verdadeiro = true;
                        }
                    }
                case 6,7,8:
                    int iii = 9;
                    for (int j = 6 ;j < iii; j++) {
                        if (this.tabuleiro[linha][j] == numero || this.tabuleiro[j][coluna] == numero) {
                            verdadeiro = true;
                        }
                    }
            }
        }
        return  false;
    }
}


