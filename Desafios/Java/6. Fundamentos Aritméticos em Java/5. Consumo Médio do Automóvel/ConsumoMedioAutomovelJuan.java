/**
 * Desafio
 * Você deve calcular o consumo médio de um automóvel onde será informada a distância total percorrida (em Km) e o total de combustível consumido (em litros).
 * <p>
 * Entrada
 * Você receberá dois valores: um valor inteiro X com a distância total percorrida (em Km), e um valor real Y que representa o total de combustível consumido, com um dígito após o ponto decimal.
 * <p>
 * Saída
 * Exiba o valor que representa o consumo médio do automóvel (3 casas após a vírgula), incluindo no final a mensagem "km/l".
 */

import java.util.*;
import java.util.stream.Collectors;

public class ConsumoMedioAutomovelJuan {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        double km = sc.nextDouble();
        double l = sc.nextDouble();

        System.out.printf(" %.3f km/l", km / l);
    }

}