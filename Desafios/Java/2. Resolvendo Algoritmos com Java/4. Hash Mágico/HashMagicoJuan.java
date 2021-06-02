/**
 * Hash Mágico
 * <p>
 * Desafio:
 * - O conceito de hash é transformar uma grande quantidade de
 * dados em uma pequena quantidade de informações. Nesse algoritmo
 * você terá uma entrada com várias linhas, cada uma com uma string.
 * <p>
 * - O valor de cada caracter é computado como segue:
 * <p>
 * - Valor = (Posição no alfabeto) + (Elemento de entrada) +
 * (Posição do elemento)
 * <p>
 * - As posições iniciam em zero. 'A' tem posição 0 no alfabeto, ‘C'
 * tem posição 2 no alfabeto, ... O cálculo de hash retornado é a soma
 * de todos os caracteres da entrada. Por exemplo, se a entrada for:
 * <p>
 * - CBA
 * - DDD
 * <p>
 * - então cada caractere deverá ser computado como segue:
 * 2 = 2 + 0 + 0 : 'C' no elemento 0 posição 0
 * 2 = 1 + 0 + 1 : 'B' no elemento 0 posição 1
 * 2 = 0 + 0 + 2 : 'A' no elemento 0 posição 2
 * 4 = 3 + 1 + 0 : 'D' no elemento 1 posição 0
 * 5 = 3 + 1 + 1 : 'D' no elemento 1 posição 1
 * 6 = 3 + 1 + 2 : 'D' no elemento 1 posição 2
 * <p>
 * - O cálculo final de hash será 2+2+2+4+5+6 = 21.
 * <p>
 * Entrada:
 * - A entrada contém vários casos de teste. A primeira linha de entrada
 * contém um inteiro N que indica a quantidade de casos de teste. Cada caso
 * de teste inicia com um inteiro L (1 ≤ L ≤ 100) que indica a quantidade de
 * linhas que vem a seguir. Cada uma destas L linhas contém uma string com até
 * 50 letras maiúsculas ('A' - 'Z').
 * <p>
 * Saída:
 * - Para cada caso de teste imprima o valor de hash que é calculado conforme o
 * exemplo apresentado acima.
 */

import java.util.Scanner;

public class HashMagicoJuan {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", linha;
        int total;

        int N1 = leitor.nextInt();
        for (int i = 0; i < N1; i++) {
            total = 0;
            int N2 = leitor.nextInt();
            for (int x = 0; x < N2; x++) {

                linha = leitor.next();
                int y = 0;
                for (char c :
                        linha.toCharArray()) {
                    total += alfabeto.indexOf(c) + y + x;
                    y++;
                }


            }

            System.out.println(total);

        }
    }

}