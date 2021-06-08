/**
 Desafio
 Faça a leitura de um valor inteiro. Em seguida, calcule o menor número de notas possíveis (cédulas) onde o valor pode ser decomposto.
 As notas que você deve considerar são de 100, 50, 20, 10, 5, 2 e 1. Na sequência mostre o valor lido e a relação de notas necessárias.

 Entrada
 Você receberá um valor inteiro N (0 < N < 1000000).

 Saída
 Exiba o valor lido e a quantidade mínima de notas de cada tipo necessárias, seguindo o exemplo de saída abaixo. Após cada linha deve ser imprimido o fim de linha.
 */

import java.util.*;
import java.util.stream.Collectors;

public class ContagemCedulasJuan {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int notas[] = {100, 50, 20, 10, 5, 2, 1};

        int valor = sc.nextInt();
        int qtde = 0;
        System.out.println(valor);

        for (int nota : notas) {
            if (valor >= nota) {

                while (valor > (qtde * nota)) {
                    qtde++;
                }
                if ((valor - (qtde * nota)) < 0) {
                    qtde--;
                }
                valor = valor - (qtde * nota);
            }
            System.out.println(qtde + " nota(s) de R$ " + nota + ",00");
            qtde = 0;
        }
    }

}