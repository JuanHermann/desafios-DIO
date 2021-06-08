/*
Leia um valor de ponto flutuante com duas casas decimais. Este valor representa um valor monetário. 
A seguir, calcule o menor número de notas e moedas possíveis no qual o valor pode ser decomposto. 
As notas consideradas são de 100, 50, 20, 10, 5, 2. As moedas possíveis são de 1, 0.50, 0.25, 0.10, 0.05 e 0.01. 
A seguir mostre a relação de notas necessárias.

Entrada
O arquivo de entrada contém um valor de ponto flutuante N (0 ≤ N ≤ 1000000.00).

Saída
Imprima a quantidade mínima de notas e moedas necessárias para trocar o valor inicial, conforme exemplo fornecido.

Obs: Utilize ponto (.) para separar a parte decimal.
*/

using System;

namespace _3._2_Notas_e_Moedas
{
    class Program
    {
        static void Main(string[] args)
        {
            int valorNotas, valorMoedas;
            string entrada;
            int[] notas = new int[] { 100, 50, 20, 10, 5, 2 };
            int[] moedas = new int[] { 50, 25, 10, 5, 1 };

            entrada = Console.ReadLine();
            valorNotas = int.Parse(entrada.Split(".")[0]);
            valorMoedas = int.Parse(entrada.Split(".")[1]);

            Console.WriteLine("NOTAS:");
            foreach (int nota in notas)
            {
                Console.WriteLine("{0} nota(s) de R$ {1}.00", valorNotas / nota, nota);
                valorNotas %= nota;
            }

            Console.WriteLine("MOEDAS:");
            Console.WriteLine("{0} moeda(s) de R$ 1.00", valorNotas / 1);

            foreach (int moeda in moedas)
            {
                Console.WriteLine("{0} moeda(s) de R$ 0.{1}", valorMoedas / moeda, (moeda < 10 ? "0" : "") + moeda.ToString());
                valorMoedas %= moeda;
            }

        }
    }
}
