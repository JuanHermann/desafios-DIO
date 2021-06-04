/*
Desafio
Neste desafio sua tarefa será ler vários números e em seguida dizer quantas vezes cada número aparece, ou seja,
deve-se escrever cada um dos valores distintos que aparecem na entrada por ordem crescente de valor.

Entrada
A primeira linha de entrada contem um único inteiro N, que indica a quantidade de valores que serão lidos para X (1 ≤ N ≤ 2000) logo em seguida.
Com certeza cada número não aparecerá mais do que 20 vezes na entrada de dados.

Saída
Imprima a saída de acordo com o exemplo fornecido abaixo, indicando quantas vezes cada um deles aparece na entrada por ordem crescente de valor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ValidadorSenhasJuan {

    public static void main(String[] args) throws IOException {
        String senha, status;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean letraMin, letraMai, letraNum, letraEspecial;

        while ((senha = in.readLine()) != null) {
            letraMin = false;
            letraMai = false;
            letraNum = false;
            status = "Senha invalida.";

            if (senha.length() >= 6 && senha.length() <= 32) {

                if (senha.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$")) {

                    for (String caracter : senha.split("")) {

                        if (caracter.matches("[a-z]")) letraMin = true;
                        if (caracter.matches("[A-Z]")) letraMai = true;
                        if (caracter.matches("[0-9]")) letraNum = true;

                    }

                    if (letraMin && letraMai && letraNum) {
                        status = "Senha valida.";
                    }
                }
            }
            System.out.println(status);
        }
    }
}