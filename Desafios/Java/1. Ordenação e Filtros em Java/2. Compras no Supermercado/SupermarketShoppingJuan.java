/**
 * Compras no Supermercado
 * <p>
 * Desafio:
 * - Pedro trabalha sempre até tarde todos os dias, com isso tem
 * pouco tempo tempo para as tarefas doméstica. Para economizar
 * tempo ele faz a lista de compras do supermercado em um aplicativo
 * e costuma anotar cada item na mesma hora que percebe a falta dele
 * em casa.
 * <p>
 * - O problema é que o aplicativo não exclui itens duplicados, como
 * Pedro anota o mesmo item mais de uma vez e a lista acaba ficando
 * extensa. Sua tarefa é melhorar o aplicativo de notas desenvolvendo
 * um código que exclua os itens duplicados da lista de compras e que
 * os ordene alfabeticamente.
 * <p>
 * Entrada:
 * - A primeira linha de entrada contém um inteiro N (N < 100) com a
 * quantidade de casos de teste que vem a seguir, ou melhor, a quantidade
 * de listas de compras para organizar. Cada lista de compra consiste de
 * uma única linha que contém de 1 a 1000 itens ou palavras compostas apenas
 * de letras minúsculas (de 1 a 20 letras), sem acentos e separadas por um
 * espaço.
 * <p>
 * Saída:
 * - A saída contém N linhas, cada uma representando uma lista de compra,
 * sem os itens repetidos e em ordem alfabética.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SupermarketShoppingJuan {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> compras = new ArrayList<>();

        String ant = "";

        int qtde = 0;
        int qtdetotal = Integer.parseInt(br.readLine());
        String linhaAtual = "";

        while (!(linhaAtual = br.readLine()).equals("")) {
            qtde++;
            for (String a : linhaAtual.split(" ")) {
                compras.add(a);
            }
            //compras.stream().sorted();

            ant = "";
            for (String b : compras.stream().sorted().collect(Collectors.toList())) {
                if (!b.equals(ant)) {
                    System.out.print(b + " ");
                    ant = b;
                }
            }

            System.out.println("");
            compras = new ArrayList<>();
            if (qtde == qtdetotal)
                break;
        }


    }

}