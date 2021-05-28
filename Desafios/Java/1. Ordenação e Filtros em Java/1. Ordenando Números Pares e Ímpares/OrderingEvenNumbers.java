/**
 * Ordenando Números Pares e Ímpares
 * <p>
 * Desafio:
 * - Crie um programa onde você receberá valores inteiros
 * não negativos como entrada.
 * <p>
 * - Ordene estes valores de acordo com o seguinte critério:
 * <p>
 * - Primeiro os Pares
 * - Depois os Ímpares
 * <p>
 * - Você deve exibir os pares em ordem crescente e na sequência
 * os ímpares em ordem decrescente.
 * <p>
 * Entrada:
 * - A primeira linha de entrada contém um único inteiro positivo
 * N (1 < N < 10000) Este é o número de linhas de entrada que vem
 * logo a seguir. As próximas N linhas terão, cada uma delas, um
 * valor inteiro não negativo.
 * <p>
 * Saída:
 * - Exiba todos os valores lidos na entrada segundo a ordem apresentada
 * acima. Cada número deve ser impresso em uma linha, conforme exemplo de
 * saída abaixo.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class OrderingEvenNumbers {

    public static void main(String[] args) throws Exception {

//        1 - Projeto Lucas
//        2 - Projeto Juan
        int opcao = 2;
        switch (opcao) {
            case 1:
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());

                int N = Integer.parseInt(st.nextToken());

                ArrayList<Integer> entrada = new ArrayList<Integer>();
                ArrayList<Integer> pares = new ArrayList<Integer>();
                ArrayList<Integer> impares = new ArrayList<Integer>();

                for (int i = 0; i < N; i++) {

                    st = new StringTokenizer(br.readLine());
                    entrada.add(Integer.parseInt(st.nextToken()));

                    if (entrada.get(i) % 2 == 0) {

                        pares.add(entrada.get(i));

                    } else {

                        impares.add(entrada.get(i));

                    }

                }

                Collections.sort(pares);
                Collections.sort(impares);

                Collections.reverse(impares);

                for (int par : pares) {

                    System.out.println(par);

                }

                for (int impar : impares) {

                    System.out.println(impar);

                }
                break;

            case 2:
                Scanner leitor = new Scanner(System.in);

                List<Integer> par = new ArrayList();
                List<Integer> impar = new ArrayList();
                int i = Integer.parseInt(leitor.next());

                while (leitor.hasNext()) {
                    i = Integer.parseInt(leitor.next());
                    if (i % 2 == 0) {
                        par.add(i);
                    } else {
                        impar.add(i);

                    }

                }
                List<Integer> parSorted = par.stream()
                        .sorted(Comparator.naturalOrder())
                        .collect(Collectors.toList());

                parSorted.forEach(System.out::println);

                List<Integer> imparSorted = impar.stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());

                imparSorted.forEach(System.out::println);
                break;

        }


    }

}