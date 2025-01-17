/*
Desafio
Todo final de ano ocorre uma festa na escola. As inscrições para participar da festa são abertas no início de julho.
 No momento da inscrição, o aluno pode escolher se quer ser "O Amigo do Pablo" na festa ou não. O mais lógico seria
 escolher a opção Sim, afinal, é um privilégio ser O Amigo do Pablo, já que ele é a pessoa mais descolada da escola.
 Porém, há indivíduos que definitivamente não pretendem ser O Amigo do Pablo, e por motivos desconhecidos.

Somente um será o escolhido. Em vista disso, muitos alunos que escolheram a opção Sim realizaram a inscrição
diversas vezes para aumentar a própria probabilidade de ser O Amigo do Pablo. A diretora da escola pediu que
você desenvolva um programa que organize as inscrições do site, pois está havendo um spam de inscrições. O critério
para ser o escolhido é a quantidade de letras do primeiro nome, e em caso de empate, vence aquele que realizou
primeiro a inscrição. A organização final dos inscritos deverá seguir a ordem de escolha (Sim ou Não),
mas respeitando a ordem alfabética.

OBS.: Ninguém que escolheu a opção Não realizou a inscrição mais de uma vez.

Entrada
A entrada contém somente um caso de teste. Cada linha é composta pelo primeiro nome do participante (sem espaços),
seguido da opção SIM (caso o usuário queira ser O Amigo do Pablo) ou NAO (caso não queira).
A entrada termina assim que o usuário digita "FIM" (sem as aspas).

Saída
Seu programa deverá imprimir os inscritos pela ordem de escolha e por ordem alfabética, seguido do nome do vencedor.
Imprima uma linha em branco entre a lista de inscritos e o nome do vencedor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MelhorAmigoPabloJuan {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> amigo = new ArrayList();
        List<String> naoAmigo = new ArrayList();
        String linhaAtual = "", nome = "";

        while (!(linhaAtual = br.readLine()).equals("FIM")) {

            nome = linhaAtual.split(" ")[0];
            if (linhaAtual.split(" ")[1].equals("SIM")) {
                if (!amigo.contains(nome)) {
                    amigo.add(nome);
                }
            } else {
                if (!naoAmigo.contains(nome)) {
                    naoAmigo.add(nome);
                }
            }

        }


        amigo.stream().sorted().forEach(System.out::println);
        naoAmigo.stream().sorted().forEach(System.out::println);

        System.out.println("");

        System.out.println("Amigo do Pablo:");

        System.out.println(amigo.stream().sorted((s1, s2) -> s2.length() - s1.length()).collect(Collectors.toList()).get(0));
    }
}