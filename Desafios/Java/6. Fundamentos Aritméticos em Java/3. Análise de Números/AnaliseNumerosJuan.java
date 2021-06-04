/**
 * Você deve fazer a leitura de 5 valores inteiros. Em seguida mostre quantos valores informados são pares, quantos valores informados são ímpares, quantos valores informados são positivos e quantos valores informados são negativos.
 * <p>
 * Entrada
 * Você receberá 5 valores inteiros.
 * <p>
 * Saída
 * Exiba a mensagem conforme o exemplo de saída abaixo, sendo uma mensagem por linha e não esquecendo o final de linha após cada uma.
 */

import java.util.*;
import java.util.stream.Collectors;

public class AnaliseNumerosJuan {

    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
//declare suas variaveis corretamente
        int par = 0;
        int impar = 0;
        int positivo = 0;
        int negativo = 0;
        int i = 0;

//continue a solução
        while (leitor.hasNext()) {
            i = Integer.parseInt(leitor.next());
            if (i % 2 == 0) {
                par++;
            } else {
                impar++;
            }
            if (i != 0) {
                if (i > 0) {
                    positivo++;
                } else {
                    negativo++;
                }
            }

        }
//insira suas variaveis corretamente
        System.out.println(par + " valor(es) par(es)");
        System.out.println(impar + " valor(es) impar(es)");
        System.out.println(positivo + " valor(es) positivo(s)");
        System.out.println(negativo + " valor(es) negativo(s)");


    }

}