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

import java.util.*;
import java.util.stream.Collectors;

public class OrderingEvenNumbersJuan {

    public static void main(String[] args) throws Exception {


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


    }

}