/**
 * O Tabuleiro Secreto
 * <p>
 * Desafio:
 * - O senhor Milli, morador da cidade Petland, é o famoso proprietário
 * da maior fábrica de jogos de tabuleiros do mundo.
 * <p>
 * - Recentemente, ele teve a ideia de lançar um novo jogo exclusivo de
 * tabuleiro, que ele apelidou de Tabuleiro da Frequência.
 * <p>
 * - O jogo ocorre da seguinte forma. Inicialmente, um tabuleiro com dimensões
 * N × N é dado contendo apenas 0’s. Depois disso, Q operações são propostas,
 * podendo ser de 4 tipos:
 * <p>
 * 1 X R: Atribuir o valor R a todos os números da linha X;
 * 2 X R: Atribuir o valor R a todos os números da coluna X;
 * 3 X: Imprimir o valor mais frequente na linha X;
 * 4 X: Imprimir o valor mais frequente da coluna X.
 * <p>
 * - Milli não é muito bom com computadores, mas é bastante preguiçoso. Sabendo
 * que você é um dos melhores programadores do mundo, ele precisa sua ajuda para
 * resolver este problema.
 * <p>
 * Entrada:
 * - A primeira linha da entrada é composta por dois inteiros N e Q (1 ≤ N, Q ≤ 105),
 * representando, respectivamente, o tamanho do tabuleiro e a quantidade de operações.
 * As próximas Q linhas da entrada vão conter as Q operações. O primeiro inteiro de cada
 * linha vai indicar o tipo da operação. Caso seja 1 ou 2, será seguido por mais dois
 * inteiros X (1 ≤ X ≤ N) e R (0 ≤ R ≤ 50). Caso seja 3 ou 4, será seguido por apenas
 * mais um inteiro X.
 * <p>
 * Saída:
 * - Para cada operação do tipo 3 ou 4, seu programa deve produzir uma linha, contendo
 * o valor da resposta correspondente. Se uma linha ou coluna tiver dois ou mais valores
 * que se repetem o mesmo número de vezes, você deve imprimir o maior deles. Por exemplo,
 * se uma linha tem os valores [5,7,7,2,5,2,1,3], tanto o 2, 5 e 7 se repetem duas vezes,
 * então a resposta será 7, pois é o maior deles.
 */


import java.util.*;
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

        Map<Integer, Integer> contagem = new HashMap<Integer, Integer>();

        for (int valor : lista) {
            if (!contagem.containsKey(valor)) {
                contagem.put(valor, 0);
            }
            contagem.put(valor, contagem.get(valor) + 1);
        }

//        int maiorK = 0, maiorV = 0;
//
//        for (Map.Entry<Integer, Integer> entry : contagem.entrySet()) {
//            if (maiorK <= entry.getKey() && maiorV <= entry.getValue()) {
//                maiorK = entry.getKey();
//                maiorV = entry.getValue();
//            }
//        }
//
//        System.out.println(maiorK);

        var key = contagem.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

        if(contagem.get(key) == 1){
            key = contagem.entrySet().stream().max((entry1, entry2) -> entry1.getKey() > entry2.getKey() ? 1 : -1).get().getKey();
        }

        System.out.println(key);

    }
}
