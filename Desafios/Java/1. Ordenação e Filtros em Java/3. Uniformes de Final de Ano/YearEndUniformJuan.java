/**
 * Uniformes de Final de Ano
 * <p>
 * Desafio:
 * - O professor Girafales organizou a confecção de um uniforme para as
 * turmas da escola para comemorar o final do ano. Após algumas conversas,
 * ficou decidido com os alunos que eles poderiam escolher a cor do uniforme
 * entre branco ou vermelho. Assim sendo, Girafales precisa de sua ajuda para
 * organizar as listas de quem quer o uniforme em cada uma das turmas, relacionando
 * estas camisetas pela cor, tamanho (P, M ou G) e por último pelo nome.
 * <p>
 * Entrada:
 * - Cada caso de teste inicia com um valor N, (1 ≤ N ≤ 60) inteiro e positivo, que
 * indica a quantidade de uniformes a serem feitas para aquela turma. As próximas N*2
 * linhas contém informações de cada um dos uniformes (serão duas linhas de informação
 * para cada uniforme). A primeira linha irá conter o nome do estudante e a segunda linha
 * irá conter a cor do uniforme ("branco" ou "vermelho") seguido por um espaço e pelo tamanho
 * do uniforme "P" "M" ou "G". A entrada termina quando o valor de N for igual a zero (0) e
 * esta valor não deverá ser processado.
 * <p>
 * Saída:
 * - Para cada caso de entrada deverão ser impressas as informações ordenadas pela
 * cor em ordem ascendente, seguido pelos tamanhos em ordem descendente e por último
 * por ordem ascendente de nome, conforme o exemplo abaixo.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class YearEndUniformJuan {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String linhaAtual = "";
        List<String> encomendas = new ArrayList<>();
        List<String> encomendasAux = new ArrayList<>();
        List<String> nomes = new ArrayList<>();
        String pedido = "";

        while (!(linhaAtual = br.readLine()).equals("0")) {

            boolean tamanho = false;

            for (String p : linhaAtual.split(" ")) {
                if (p.equals("P") || p.equals("M") || p.equals("G")) {
                    tamanho = true;
                }
            }

            if (tamanho) {
                pedido = linhaAtual + " " + pedido;

                encomendas.add(pedido);

                pedido = "";

            } else {
                pedido = linhaAtual;
            }


        }

        encomendas = encomendas.stream().sorted().collect(Collectors.toList());
        char ant = '\0';
        char antAux = '\0';
        for (String a : encomendas) {
            char c = a.charAt(0);
            if (c != ant) {
                ant = c;
                for (String b : encomendas) {
                    if (c == b.charAt(0)) {
                        encomendasAux.add(b);

                    }

                }

                encomendasAux = encomendasAux.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
                for (String d : encomendasAux) {
                    char f = d.charAt(d.indexOf(" ") + 1);
                    if (f != antAux) {
                        antAux = f;
                        for (String b : encomendasAux) {
                            if (f == b.charAt(d.indexOf(" ") + 1)) {
                                nomes.add(b);

                            }

                        }
                        nomes.stream().sorted().forEach(System.out::println);
                        nomes = new ArrayList<>();

                    }
                }
                antAux = '\0';
                encomendasAux = new ArrayList<>();

            }
        }

    }

}