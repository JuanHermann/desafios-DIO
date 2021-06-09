using System;

namespace Pink_E_Cerebro
{
    class Program
    {
        static void Main(string[] args)
        {
            int suavariavel = int.Parse(Console.ReadLine());
            int mDois = 0, mTres = 0, mQuatro = 0, mCinco = 0;

            string[] n = Console.ReadLine().Split();
            int num = 0;
            foreach (string s in n)
            {
                num = int.Parse(s);

                if (num % 2 == 0)
                {
                    mDois++;
                }
                if (num % 3 == 0)
                {
                    mTres++;
                }
                if (num % 4 == 0)
                {
                    mQuatro++;
                }
                if (num % 5 == 0)
                {
                    mCinco++;
                }

            }
            Console.WriteLine("{0} Multiplo(s) de 2", mDois);
            Console.WriteLine("{0} Multiplo(s) de 3", mTres);
            Console.WriteLine("{0} Multiplo(s) de 4", mQuatro);
            Console.WriteLine("{0} Multiplo(s) de 5", mCinco);
        }
    }
}