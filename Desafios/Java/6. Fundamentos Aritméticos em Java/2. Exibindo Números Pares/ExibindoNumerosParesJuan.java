/**
 Desafios
 Crie um programa que leia um número e mostre os números pares até esse número, inclusive ele mesmo.

 Entrada
 Você receberá 1 valor inteiro N, onde N > 0.

 Saída
 Exiba todos os números pares até o valor de entrada, sendo um em cada linha.
 */

import java.util.*;
import java.util.stream.Collectors;

public class ExibindoNumerosParesJuan {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        for (int i = 1; i <= a; i++) {
            if (i % 2 == 0) System.out.println(i);
        }


    }

}