/*
Desafio
Nesse algoritmo você deverá descobrir se um conjunto de palavras é bom ou ruim. Por definição,
um conjunto é bom quando nenhuma palavra desse conjunto é um prefixo de outra palavra. Caso contrário, é considerado um conjunto ruim.

Por exemplo, {dbc, dae, dbcde} é um conjunto ruim, pois dbc é um prefixo de dbcde.
Quando duas palavras são idênticas, definimos como uma sendo prefixo da outra.

Entrada
A entrada contém vários casos de teste. A primeira linha de cada caso de teste terá um inteiro N (1 ≤ N ≤ 10⁵),
que representa a quantidade de palavras no conjunto. Segue então N linhas, cada uma tendo uma palavra de no máximo 100 letras minúsculas.
A entrada termina quando N = 0 e não deve ser processada.

Saída
Para cada caso de teste, você deverá imprimir "Conjunto Bom", ou "Conjunto Ruim", conforme explicado acima.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConjuntosBOuRJuan {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String linhaAtual = "";
        List<String> palavras;
        Integer qtdeConjunto = 0, qtde = 0;

        while (!(linhaAtual = br.readLine()).equals("0")) {

            palavras = new ArrayList<>();
            qtdeConjunto = Integer.parseInt(linhaAtual);
            qtde = 0;

            while (qtdeConjunto > qtde) {
                linhaAtual = br.readLine();
                palavras.add(linhaAtual);
                qtde++;

            }

            Boolean cRuim = false;

            Collections.sort(palavras, (a, b) -> Integer.compare(b.length(), a.length()));
            for (String x : palavras) {
                for (int i = palavras.indexOf(x) + 1; i < palavras.size(); i++) {
                    if (x.startsWith(palavras.get(i))) {
                        cRuim = true;
                        break;
                    }
                }
                if (cRuim) break;
            }

            System.out.println("Conjunto " + ((cRuim) ? "Ruim" : "Bom"));


        }
    }
}