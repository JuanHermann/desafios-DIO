using System;
using System.Globalization;

namespace Coordenadas_De_Um_Ponto
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] linha = Console.ReadLine().Split();
            double x = double.Parse(linha[0]);
            double y = double.Parse(linha[1]);

            if (x == 0 && y == 0)
            {
                Console.WriteLine("Origem");
            }
            else if (y == 0)
            {
                Console.WriteLine("Eixo X");
            }
            else if (x == 0)
            {
                Console.WriteLine("Eixo Y");
            }
            else if (x > 0 && y > 0)
            {
                Console.WriteLine("Q1");
            }
            else if (x < 0 && y > 0)
            {
                Console.WriteLine("Q2");
            }
            else if (x < 0 && y < 0)
            {
                Console.WriteLine("Q3");
            }
            else if (x > 0 && y < 0)
            {
                Console.WriteLine("Q4");
            }
        }
    }
}