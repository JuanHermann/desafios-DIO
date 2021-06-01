/**
 * Combinação de Strings
 * <p>
 * Desafio:
 * - Crie um algoritmo que receba dois inputs que sejam strings e combine-as
 * alternando as letras de cada string.
 * <p>
 * - Deve começar pela primeira letra da primeira string, seguido pela primeira
 * letra da segunda string, em seguida pela segunda letra da primeira string e
 * continuar dessa forma sucessivamente.
 * <p>
 * - As letras restantes da cadeia mais longa devem ser adicionadas ao fim da
 * string resultante e retornada.
 * <p>
 * Entrada:
 * - A entrada contém vários casos de teste. A primeira linha contém um inteiro
 * N que indica a quantidade de casos de teste que vem a seguir. Cada caso de teste
 * é composto por uma linha que contém duas cadeias de caracteres, cada cadeia de
 * caracteres contém entre 1 e 50 caracteres inclusive.
 * <p>
 * Saída:
 * - Combine as duas cadeias de caracteres da entrada como mostrado no exemplo abaixo
 * e exiba a cadeia resultante.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        1 - Projeto Lucas
//        2 - Projeto Juan
        int opcao = 2;
        switch (opcao) {
            case 1:


                Scanner scan = new Scanner(System.in);
                int casos = Integer.parseInt(scan.nextLine());

                for (int i = 1; i <= casos; i++) {

                    StringBuilder analise = new StringBuilder();
                    String[] palavras = scan.nextLine().split(" ");

                    int maxSize = Math.max(
                            palavras[0].length(),
                            palavras[1].length());

                    for (int dados = 0; dados < maxSize; dados++) {

                        if (dados < palavras[0].length()) {

                            analise.append(palavras[0].charAt(dados));

                        }

                        if (dados < palavras[1].length()) {

                            analise.append(palavras[1].charAt(dados));

                        }

                    }

                    System.out.println(analise.toString());

                }
                break;
            case 2:


                Scanner leitor = new Scanner(System.in);
                String resultado, s1, s2;
                int menor;
                boolean p1, p2;

                int N = leitor.nextInt();
                for (int i = 0; i < N; i++) {

                    s1 = leitor.next();
                    s2 = leitor.next();
                    resultado = "";
                    p1 = false;
                    p2 = false;

                    if (s1.length() > s2.length()) {
                        menor = s2.length();
                        p1 = true;
                    } else {
                        if (s1.length() != s2.length()) {
                            p2 = true;
                        }
                        menor = s1.length();
                    }
                    for (int j = 0; j < menor; j++) {
                        resultado += "" + s1.charAt(j) + s2.charAt(j);

                    }

                    if (p1) resultado += s1.substring(menor);
                    if (p2) resultado += s2.substring(menor);

                    System.out.println(resultado);
                }
                break;
        }


    }
}