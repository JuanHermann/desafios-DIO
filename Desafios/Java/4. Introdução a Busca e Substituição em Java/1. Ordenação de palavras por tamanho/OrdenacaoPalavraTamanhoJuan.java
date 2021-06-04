/*
Desafio
Pedro e Fernando são os desenvolvedores em uma stratup e vão desenvolver o novo sistema de cadastro, e pediram a sua ajuda. Sua task é fazer o código que valide as senhas que são cadastradas, para isso você deve atentar aos requisitos a seguir:

A senha deve conter, no mínimo, uma letra maiúscula, uma letra minúscula e um número;
A mesma não pode ter nenhum caractere de pontuação, acentuação ou espaço;
Além disso, a senha pode ter de 6 a 32 caracteres.
Entrada
A entrada contém vários casos de teste e termina com final de arquivo. Cada linha tem uma string S, correspondente a senha que é inserida pelo usuário no momento do cadastro.

Saída
A saída contém uma linha, que pode ser “Senha valida.”, caso a senha tenha cada item dos requisitos solicitados anteriormente, ou “Senha invalida.”, se um ou mais requisitos não forem atendidos.
 */

import java.util.*;

public class OrdenacaoPalavraTamanhoJuan {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        List<String> palavras = new ArrayList();
        String linha = "";
        int qtdeCaso = 0, caso = 0;

        while (leitor.hasNext()) {
            if (caso == 0) {
                caso = Integer.parseInt(leitor.nextLine());
            } else {
                linha = leitor.nextLine();
                for (String p : linha.split(" ")) {
                    palavras.add(p);
                }
                palavras.stream().sorted().sorted((s1, s2) -> s2.length() - s1.length()).forEach(s1 -> System.out.print(s1 + " "));
                System.out.println("");
                palavras = new ArrayList<>();


                qtdeCaso++;

                if (qtdeCaso == caso)
                    break;


            }

        }
    }
}