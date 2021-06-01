import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainJuan {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<Integer> numeros;

        int tamanho = leitor.nextInt();
        int casos = leitor.nextInt();
        int[][] tabuleiro = new int[tamanho][tamanho];
        for (int i = 0; i < casos; i++) {

            int num1 = leitor.nextInt();
            int num2 = leitor.nextInt() - 1;
            int num3 = 0;
            numeros = new ArrayList<>();
            switch (num1) {
                case 1:
                    num3 = leitor.nextInt();

                    for (int x = 0; x < tamanho; x++) {

                        tabuleiro[num2][x] = num3;

                    }

                    break;
                case 2:
                    num3 = leitor.nextInt();

                    for (int x = 0; x < tamanho; x++) {

                        tabuleiro[x][num2] = num3;

                    }
                    break;
                case 3:

                    for (int x = 0; x < tamanho; x++) {

                        numeros.add(tabuleiro[num2][x]);

                    }

                    maiorRepeticao(numeros);
                    break;
                case 4:

                    for (int x = 0; x < tamanho; x++) {

                        numeros.add(tabuleiro[x][num2]);

                    }

                    maiorRepeticao(numeros);
                    break;

            }
        }
    }

    public static void maiorRepeticao(List<Integer> lista) {

        int qtde = 0, maiorRepeticao = 0, qtdeMaior = -1, atualRepeticao = 0;

        for (int atual : lista.stream().sorted().collect(Collectors.toList())) {

            if (atual != atualRepeticao) qtde = 0;

            qtde++;

            if (qtdeMaior <= qtde) {
                qtdeMaior = qtde;
                maiorRepeticao = atual;
                atualRepeticao = atual;
            }
        }


        System.out.println(maiorRepeticao);
    }
}
