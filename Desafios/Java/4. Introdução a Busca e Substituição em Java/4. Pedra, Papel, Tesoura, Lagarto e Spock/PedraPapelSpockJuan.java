/*
Desafio
Pedra-papel-tesoura-lagarto-Spock é uma expansão do clássico método de seleção em jogo de pedra-papel-tesoura. Atua sob o mesmo princípio básico, mas inclui outras duas armas adicionais: o lagarto (formado pela mão igual a uma boca de fantoche) e Spock (formada pela saudação dos vulcanos em Star Trek). Isso reduz as chances de uma rodada terminar em um empate. O jogo foi inventado por Sam Kass e Karen Bryla, como "Rock Paper Scissors Lizard Spock". As regras de vantagem são as seguintes:

Tesoura corta papel
Papel cobre pedra
Pedra derruba lagarto
Lagarto adormece Spock
Spock derrete tesoura
Tesoura prende lagarto
Lagarto come papel
Papel refuta Spock
Spock vaporiza pedra
Pedra quebra tesoura
Um dia, duas amigas, Fernanda e Marcia, decidiram apostar quem pagaria um almoço para o outro, com esta brincadeira. Sua missão será fazer um algoritmo que, baseado no que eles escolherem, informe quem irá ganhar ou se dará empate.

Entrada
Haverá diversos casos de teste. O primeiro número a ser lido será um inteiro, representando a quantidade de casos de teste. Cada caso de teste tem duas palavras, representando a escolha de Fernanda e de Marcia, respectivamente.

Saída
Para cada caso de teste, imprima quem venceu, ou se houve empate.
 */

import java.util.*;

public class PedraPapelSpockJuan {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String linha = "", s1, s2;
        int qtdeCaso = 0, caso = 0;

        while (leitor.hasNext()) {
            if (caso == 0) {
                caso = Integer.parseInt(leitor.nextLine());
            } else {
                linha = leitor.nextLine();
                s1 = linha.split(" ")[0];
                s2 = linha.split(" ")[1];

                if (s1.equals(s2)) {
                    System.out.println("empate");
                } else if (
                        s1.equals("tesoura") && (s2.equals("papel") || s2.equals("lagarto")) ||
                                s1.equals("papel") && (s2.equals("pedra") || s2.equals("spock")) ||
                                s1.equals("pedra") && (s2.equals("lagarto") || s2.equals("tesoura")) ||
                                s1.equals("lagarto") && (s2.equals("spock") || s2.equals("papel")) ||
                                s1.equals("spock") && (s2.equals("tesoura") || s2.equals("pedra"))
                ) {

                    System.out.println("Fernanda");
                } else {
                    System.out.println("Marcia");
                }

                qtdeCaso++;

                if (qtdeCaso == caso)
                    break;


            }

        }
    }
}