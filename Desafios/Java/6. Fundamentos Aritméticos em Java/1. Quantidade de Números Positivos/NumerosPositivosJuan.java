/**
 * Desafio
 * Crie um programa que leia 6 valores. Você poderá receber valores negativos e/ou positivos como entrada, devendo desconsiderar os valores nulos. Em seguida, apresente a quantidade de valores positivos digitados.
 * <p>
 * Entrada
 * Você receberá seis valores, negativos e/ou positivos.
 * <p>
 * Saída
 * Exiba uma mensagem dizendo quantos valores positivos foram lidos assim como é exibido abaixo no exemplo de saída. Não esqueça da mensagem "valores positivos" ao final.
 */

import java.util.*;
import java.util.stream.Collectors;

public class NumerosPositivosJuan {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        List<Double> leitor = new ArrayList<>();

        int qtde = 6;
        while (qtde-- > 0)
            leitor.add(sc.nextDouble());

        int positivo = 0;

        for (Double i : leitor) {
            if (i > 0) {
                positivo++;
            }
        }
        System.out.println(positivo + " valores positivos");


    }

}