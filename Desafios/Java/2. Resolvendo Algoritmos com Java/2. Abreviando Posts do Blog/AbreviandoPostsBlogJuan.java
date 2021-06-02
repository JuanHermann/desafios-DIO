/**
 * Abreviando Posts do Blog
 * <p>
 * Desafio:
 * - Leonardo é um nômade digital e viaja pelo mundo programando em diferentes cafés das
 * cidades por onde passa. Recentemente, resolveu criar um blog, para compartilhar suas
 * experiências e aprendizados com seus amigos.
 * <p>
 * - Para criação do blog, ele optou por utilizar uma ferramenta pronta, que há um limite
 * de caracteres que se pode escrever por dia, e Leonardo está preocupado que essa limitação,
 * afinal, irá impedir de contar suas melhores experiências. Para contornar esse problema,
 * decidiu usar um sistema de abreviação de palavras em seus posts.
 * <p>
 * - O sistema de abreviações é simples e funciona da seguinte forma: para cada letra, é possível
 * escolher uma palavra que inicia com tal letra e que aparece no post. Uma vez escolhida a palavra,
 * sempre que ela aparecer no post, ela será substituída por sua letra inicial e um ponto, diminuindo
 * assim o número de caracteres impressos na tela.
 * <p>
 * - Por exemplo, na frase: “hoje eu programei em Python”, podemos escolher a palavra “programei”
 * para representar a letra ‘p', e a frase ficará assim: “hoje eu p. em Python”, economizando assim
 * sete caracteres. Uma mesma palavra pode aparecer mais de uma vez no texto, e será abreviada todas
 * as vezes. Note que, se após uma abreviação o número de caracteres não diminuir, ela não deve ser
 * usada, tal como no caso da palavra “eu” acima.
 * <p>
 * - Leonardo precisa que seu post tenha o menor número de caracteres possíveis, e por isso pediu a
 * sua ajuda. Para cada letra, escolha uma palavra, de modo que ao serem aplicadas todas as abreviações,
 * o texto contenha o menor número de caracteres possíveis.
 * <p>
 * Entrada:
 * - Haverá diversos casos de teste. Cada caso de teste é composto de uma linha, contendo uma frase de até
 * 10⁴ caracteres. A frase é composta de palavras e espaços em branco, e cada palavra é composta de letras
 * minúsculas ('a'-'z'), e contém entre 1 e 30 caracteres cada.
 * <p>
 * - O último caso de teste é indicado quando a linha dada conter apenas um “.”, o qual não deverá ser
 * processado.
 * <p>
 * Saída:
 * - Para cada caso de teste, imprima uma linha contendo a frase já com as abreviações escolhidas e aplicadas.
 * <p>
 * - Em seguida, imprima um inteiro N, indicando o número de palavras em que foram escolhidas uma letra para a
 * abreviação no texto. Nas próximas N linhas, imprima o seguinte padrão “C. = P”, onde C é a letra inicial e P
 * é a palavra escolhida para tal letra. As linhas devem ser impressas em ordem crescente da letra inicial.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AbreviandoPostsBlogJuan {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String linhaAtual = "";
        List<String> palavras, palavrasLimpas;
        Integer qtde = 0;

        while (!(linhaAtual = br.readLine()).equals(".")) {
            st = new StringTokenizer(linhaAtual);
            String p = "", frase = "";
            palavras = new ArrayList<>();
            palavrasLimpas = new ArrayList<>();
            qtde = 0;

            while (st.hasMoreTokens()) {
                p = st.nextToken();

                if (p.length() > 2) {
                    if (!palavras.contains(p)) {
                        palavras.add(p);
                    }
                }

                frase = frase + p + " ";
            }

            boolean maior;
            for (String a : palavras) {
                maior = true;
                for (String b : palavras) {
                    if (!a.equals(b)) {
                        if (a.charAt(0) == b.charAt(0)) {
                            if (((a.length() - 2) * contaOcorrencias(a, frase)) < ((b.length() - 2) * contaOcorrencias(b, frase))) {
                                maior = false;

                            }
                        }
                    }
                }
                if (maior) {
                    palavrasLimpas.add(a);
                }
            }

            for (String a : frase.split(" ")) {
                if (palavrasLimpas.contains(a)) {
                    qtde++;
                }
            }

            Collections.sort(palavrasLimpas, (a, b) -> Integer.compare(b.length(), a.length()));

            for (String trocaPalavra : palavrasLimpas) {
                frase = frase.replaceAll(trocaPalavra + " ", trocaPalavra.charAt(0) + ". ");
            }


            System.out.println(frase);
            System.out.println(palavrasLimpas.size());

            Collections.sort(palavrasLimpas);
            for (String siglas : palavrasLimpas) {
                System.out.println(siglas.charAt(0) + ". = " + siglas);
            }


        }
    }

    public static int contaOcorrencias(String palavra, String str) {

        int count = 0;
        for (String s : str.split(" ")) {
            if (s.equals(palavra)) {
                count++;
            }
        }
        return count;
    }

}