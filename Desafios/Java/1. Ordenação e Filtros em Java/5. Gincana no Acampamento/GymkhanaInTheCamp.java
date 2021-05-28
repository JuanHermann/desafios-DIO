/**
 * Gincana no Acampamento
 * <p>
 * Desafio:
 * - Nas férias de Dezembro, várias escolas se organizam e levam seus
 * alunos para um acampamento de férias por uma semana. Nestes acampamentos
 * os alunos são divididos em cabanas coletivos por gênero e idade, sempre
 * com um adulto que, além de dormir com o grupo no cabana, também são
 * responsáveis por criar e executar várias atividades, como por exemplo
 * jogos, excursões, Gincanas Noturnas, etc.
 * <p>
 * - No primeiro dia foi realizada uma gincana em que a atividade constituia
 * em agrupar os alunos em um círculo (organizado no sentido anti-horário) do
 * qual seriam retiradas uma a uma até que sobrasse apenas um aluno, que seria
 * o vencedor.
 * <p>
 * - No momento em que entra no círculo, cada aluno recebe uma pequena ficha
 * que contém um valor de 1 a 500. Depois que o círculo é formado, conta-se,
 * iniciando no aluno que está ao lado da primeira que entrou no círculo, o
 * número correspondente à ficha que o primeiro detém. O aluno onde o número
 * contado cair, deve ser retirado do grupo, e a contagem inicia novamente
 * segundo a ficha do aluno que acabou de ser eliminado. Para ficar mais
 * interessante, quando o valor que consta na ficha é par, a contagem é feita
 * no sentido horário e quando o valor que consta na ficha é ímpar, a contagem
 * é feita no sentido anti-horário.
 * <p>
 * - Desenvolva um programa para que no próximo evento o responsável pela brincadeira
 * saiba previamente qual criança irá ser a vencedora de cada grupo, com base nas
 * informações fornecidas.
 * <p>
 * Entrada:
 * - A entrada contém vários casos de teste. A primeira linha de cada caso de teste
 * contém um inteiro N (1 ≤ N ≤ 100), indicando a quantidade de alunos que farão parte
 * de cada círculo. Em seguida, as N linhas de cada caso de teste conterão duas informações,
 * o Nome e o Valor (1 ≤ Valor ≤ 500) que consta na ficha de cada aluno, separados por um
 * espaço, na ordem de entrada na formação do círculo inicial.
 * <p>
 * - OBS: O Nome de cada aluno não deverá ultrapassar 30 caracteres e contém apenas letras
 * maiúsculas e minúsculas, sem acentos, e o caractere “_”. O final da entrada é indicado
 * pelo número zero.
 * <p>
 * Saída:
 * - Para cada caso de teste, deve-se apresentar a mensagem Vencedor(a): xxxxxx, com um espaço
 * após o sinal ":" indicando qual é o aluno do grupo que venceu a brincadeira.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GymkhanaInTheCamp {

    public static void main(String[] args) {

//        1 - Projeto Lucas
//        2 - Projeto Juan
        int opcao = 2;
        switch (opcao) {
            case 1:
                Scanner scr = new Scanner(System.in);
                List<String> listaAlunos = new ArrayList<>();

                int numeroDeAlunos;
                String aluno;
                String valorFicha;
                int valorAtualFicha;
                int indiceAtual;
                int indiceAlunoEliminado;

                numeroDeAlunos = Integer.parseInt(scr.next());

                while (numeroDeAlunos > 0) {

                    for (int i = 0; i < numeroDeAlunos; i++) {

                        aluno = scr.next();
                        valorFicha = scr.next();
                        listaAlunos.add(aluno.trim() + " " + valorFicha.trim());

                    }

                    indiceAtual = 0;
                    indiceAlunoEliminado = 0;
                    valorAtualFicha = Integer.parseInt(listaAlunos.get(indiceAtual).split(" ")[1]);

                    for (int i = 0; i < numeroDeAlunos - 1; i++) {

                        if (valorAtualFicha % 2 == 0) {

                            indiceAlunoEliminado = (listaAlunos.size() - (valorAtualFicha % listaAlunos.size()) + indiceAtual) % listaAlunos.size();

                        } else if (valorAtualFicha % 2 != 0) {

                            indiceAlunoEliminado = (valorAtualFicha % listaAlunos.size() + indiceAtual) % listaAlunos.size();

                        }

                        valorAtualFicha = Integer.parseInt(listaAlunos.get(indiceAlunoEliminado).split(" ")[1]);
                        listaAlunos.remove(indiceAlunoEliminado);

                        indiceAtual = (valorAtualFicha % 2 == 0) ?
                                ((indiceAlunoEliminado <= listaAlunos.size() - 1) ?
                                        indiceAlunoEliminado : 0) :
                                ((indiceAlunoEliminado == 0) ?
                                        (listaAlunos.size() - 1) : (indiceAlunoEliminado - 1));

                    }

                    System.out.println("Vencedor(a): " + listaAlunos.get(0).split(" ")[0]);

                    listaAlunos.clear();
                    numeroDeAlunos = Integer.parseInt(scr.next());

                }

                scr.close();
                break;
            case 2:
                Scanner leitor = new Scanner(System.in);

                List<String> alunos = new ArrayList();
                int fila = 0, numero = 0;

                while (leitor.hasNext()) {

                    if (fila == 0) {

                        fila = Integer.parseInt(leitor.nextLine());

                        if (fila == 0)
                            break;

                    } else {
                        alunos.add(leitor.nextLine());
                        if (alunos.size() == fila) {

                            numero = Integer.parseInt(alunos.get(0).split(" ")[1]);
                            int index = 0;
                            while (alunos.size() > 1) {

                                for (int i = 1; i <= numero; i++) {

                                    if (numero % 2 != 0) {
                                        index++;
                                        if (index == alunos.size()) {
                                            index = 0;
                                        }
                                    } else {
                                        index--;
                                        if (index < 0) {
                                            index = alunos.size() - 1;
                                        }
                                    }

                                }

                                numero = Integer.parseInt(alunos.get(index).split(" ")[1]);
                                alunos.remove(index);

                                if (numero % 2 != 0) {
                                    index--;
                                }

                            }

                            System.out.println("Vencedor(a): " + alunos.get(0).split(" ")[0]);

                            alunos = new ArrayList<>();
                            fila = 0;


                        }

                    }


                }
                break;
        }


    }

}