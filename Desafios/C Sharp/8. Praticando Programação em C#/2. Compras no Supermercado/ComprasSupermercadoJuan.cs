using System;
using System.Collections.Generic;
using System.Linq;

class ComprasNoSupermercado
{
    public static void Main(string[] args)
    {
        List<string> listaLimpa = new List<string>();
        var totalDeCasosDeTeste = int.Parse(Console.ReadLine());
        for (int i = 0; i < totalDeCasosDeTeste; i++)
        {
            string[] linha = Console.ReadLine().Split();

            foreach (string compra in linha)
            {
                if (!listaLimpa.Contains(compra))
                {
                    listaLimpa.Add(compra);
                }
            }
            listaLimpa.OrderBy(q => q).ToList().ForEach(s1 => Console.Write(s1 + " "));
            Console.WriteLine("");

            listaLimpa.Clear();
        }
    }
}