/**
 * Coração das Cartas
 * <p>
 * Desafio:
 * - Marcos decidiu abandonar o bar da faculdade onde jogava truco para dedicar-se ao
 * mundo da programação. Para que isso fosse mais fácil, decidiu criar um novo jogo
 * de cartas.
 * <p>
 * - O coração das cartas, como Marcos apelidou o jogo, é individual e jogado com três
 * pilhas, inicialmente com o mesmo número de cartas. Cada carta tem um valor numérico
 * inteiro de 0 até 9. O jogador pode, a qualquer momento ver o valor de qualquer carta,
 * mas só pode jogar com as cartas que estão no topo das pilhas. Em cada rodada, o jogador
 * pode remover qualquer combinação de cartas que estejam no topo da pilha (pode escolher 1,
 * 2 ou até 3 cartas) cuja soma dos valores seja múltiplo de 3. O jogo é ganho quando todas
 * as cartas forem removidas das pilhas. Se alguma carta não puder ser removida, perde-se o
 * jogo.
 * <p>
 * Entrada:
 * - A entrada é composta por várias instâncias Cada instância é iniciada por um inteiro N
 * (0 ≤ N ≤ 100), que identifica o número de cartas em cada pilha. A entrada termina quando
 * N = 0. Cada uma das N linhas seguintes contém três inteiros A, B e C, que descrevem os
 * valores numéricos das cartas em um nível da pilha (0 ≤ A, B, C ≤  9). As pilhas são
 * descritas do topo até o fundo.
 * <p>
 * Saída:
 * - Para cada instância, imprima uma linha contendo o número 1 se o jogador pode ganhar a
 * instância do jogo ou o número 0 se o jogo for impossível.
 */

import java.awt.image.ReplicateScaleFilter;
import java.util.*;

public class Main {

    static Map<String, Integer> m = new HashMap<String, Integer>();
    static int n;
    static int[][] pilha = new int[3][102];

    static public boolean cartas(int a, int b, int c) {

        String ss = "" + a + b + c;

        if (a == b && b == c && c == n) {

            m.putIfAbsent(ss, 1);
            return true;

        }

        int x = m.getOrDefault(ss, 0);

        if (x > 0) return (x == 1 ? true : false);

        if (a < n && pilha[0][a] % 3 == 0 && cartas(a + 1, b, c)) {

            m.putIfAbsent(ss, 1);
            return true;

        }

        if (b < n && pilha[1][b] % 3 == 0 && cartas(a, b + 1, c)) {

            m.putIfAbsent(ss, 1);
            return true;

        }

        if (c < n && pilha[2][c] % 3 == 0 && cartas(a, b, c + 1)) {

            m.putIfAbsent(ss, 1);
            return true;

        }
        if (a < n && b < n && (pilha[0][a] + pilha[1][b]) % 3 == 0 && cartas(a + 1, b + 1, c)) {

            m.putIfAbsent(ss, 1);
            return true;
        }

        if (a < n && c < n && (pilha[0][a] + pilha[2][c]) % 3 == 0 && cartas(a + 1, b, c + 1)) {
            m.putIfAbsent(ss, 1);
            return true;

        }

        if (b < n && c < n && (pilha[1][b] + pilha[2][c]) % 3 == 0 && cartas(a, b + 1, c + 1)) {

            m.putIfAbsent(ss, 1);
            return true;

        }

        if (a < n && b < n && c < n && (pilha[0][a] + pilha[1][b] + pilha[2][c]) % 3 == 0 && cartas(a + 1, b + 1, c + 1)) {

            m.putIfAbsent(ss, 1);
            return true;
        }

        m.putIfAbsent(ss, 2);
        return false;

    }

    public static void main(String[] args) {

//        1 - projeto do Lucas
//        2 - projeto do Juan
//        3 - gerador de casos de teste
        int opcao = 3;


        switch (opcao) {
            case 2:
                Scanner leitor = new Scanner(System.in);

                String linha;
                int qtdeCaso = 0, caso = 0;

                while (leitor.hasNext()) {
                    if (caso == 0) {
                        caso = Integer.parseInt(leitor.nextLine());
                        if (caso == 0)
                            break;

                    } else {
                        linha = leitor.nextLine();
                        pilha[0][qtdeCaso] = Integer.parseInt(linha.split(" ")[0]);
                        pilha[1][qtdeCaso] = Integer.parseInt(linha.split(" ")[1]);
                        pilha[2][qtdeCaso] = Integer.parseInt(linha.split(" ")[2]);

                        qtdeCaso++;

                        if (qtdeCaso == caso) {
                            n = qtdeCaso;
                            System.out.println(ganhou(0, 0, 0) ? "1" : "0");
                            pilha = new int[3][102];
                            caso = 0;
                            qtdeCaso = 0;
                            m.clear();
                        }

                    }
                }
                break;
            case 1:

                Scanner in = new Scanner(System.in);

                while (true) {

                    n = Integer.parseInt(in.nextLine());

                    if (n == 0) break;

                    for (int i = 0; i < n; i++) {

                        StringTokenizer st = new StringTokenizer(in.nextLine());
                        pilha[0][i] = Integer.parseInt(st.nextToken());
                        pilha[1][i] = Integer.parseInt(st.nextToken());
                        pilha[2][i] = Integer.parseInt(st.nextToken());

                    }

                    if (cartas(0, 0, 0) == true) System.out.println("1");
                    else System.out.println("0");
                    m.clear();
                }
                break;
            case 3:
                Random r = new Random();
                for (int i = 0; i < 10; i++) {
                    int numDado = r.nextInt(101) + 1;
                    System.out.println(numDado);
                    for (int x = 0; x < numDado; x++) {
                        System.out.print(r.nextInt(10));
                        System.out.print(" ");
                        System.out.print(r.nextInt(10));
                        System.out.print(" ");
                        System.out.print(r.nextInt(10));
                        System.out.println("");
                    }
                }
                System.out.println(0);
                break;

        }
    }

    private static boolean ganhou(int pA, int pB, int pC) {

        boolean aPassou = pA == n;
        boolean bPassou = pB == n;
        boolean cPassou = pC == n;

        if (aPassou && bPassou && cPassou) {
            return true;
        } else {

            int a = pilha[0][pA];
            int b = pilha[1][pB];
            int c = pilha[2][pC];

            String ss = "" + pA + pB + pC;

            int x = m.getOrDefault(ss, 0);

            if (x > 0) return (x == 1);

            if (!aPassou && !bPassou && !cPassou && ((a + b + c) % 3 == 0) && ganhou(pA + 1, pB + 1, pC + 1)) {
                m.putIfAbsent(ss, 1);
                return true;
            } else if (!aPassou && !bPassou && ((a + b) % 3 == 0) && ganhou(pA + 1, pB + 1, pC)) {
                m.putIfAbsent(ss, 1);
                return true;
            } else if (!aPassou && !cPassou && ((a + c) % 3 == 0) && ganhou(pA + 1, pB, pC + 1)) {
                m.putIfAbsent(ss, 1);
                return true;
            } else if (!bPassou && !cPassou && ((b + c) % 3 == 0) && ganhou(pA, pB + 1, pC + 1)) {
                m.putIfAbsent(ss, 1);
                return true;
            } else if (!aPassou && (a % 3 == 0) && ganhou(pA + 1, pB, pC)) {
                m.putIfAbsent(ss, 1);
                return true;
            } else if (!bPassou && (b % 3 == 0) && ganhou(pA, pB + 1, pC)) {
                m.putIfAbsent(ss, 1);
                return true;
            } else if (!cPassou && (c % 3 == 0) && ganhou(pA, pB, pC + 1)) {
                m.putIfAbsent(ss, 1);
                return true;
            }

            m.putIfAbsent(ss, 2);
            return false;
        }


    }

}