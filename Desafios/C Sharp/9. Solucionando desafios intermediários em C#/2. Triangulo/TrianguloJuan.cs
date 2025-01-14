/*
Leia 3 valores reais (A, B e C) e verifique se eles formam ou não um triângulo. Em caso positivo, calcule o perímetro do triângulo e apresente a mensagem:


Perimetro = XX.X


Em caso negativo, calcule a área do trapézio que tem A e B como base e C como altura, mostrando a mensagem


Area = XX.X

Entrada
A entrada contém três valores reais.

Saída
O resultado deve ser apresentado com uma casa decimal.
*/
using System;
using System.Globalization;

namespace Coordenadas_De_Um_Ponto
{
    class Program
    {
        static void Main(string[] args)
        {
            double a, b, c;
            string[] valor = Console.ReadLine().Split();
            a = Convert.ToDouble(valor[0]);
            b = Convert.ToDouble(valor[1]);
            c = Convert.ToDouble(valor[2]);

            if ((a + b > c) && (a + c > b) && (b + c > a))
            {
                Console.WriteLine("Perimetro = {0:0.0}", a + b + c);
            }
            else
            {
                Console.WriteLine("Area = {0:0.0}", a + b);
            }
        }
    }
}