public class Algorithms {

    public static void linearAlgorithm(long N)
    {
        int x;
        for(int i = 1; i <= N; i++)
            x = 1;
    }

    public static void quadraticAlgorithm(long N)
    {
        int x;
        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N; j++)
            {
                x = 1;
            }
        }
    }

    public static void logarithmicAlgorithm(long N)
    {
        int x;
        for(int i = (int)N; i >= 1; i = i/2)
            x = 1;
    }

    public static void NlogNAlgorithm(long N)
    {
        int x;
        for(int i = 1; i <= N; i++)
        {
            for(int j = (int)N; j >= 1; j = j/2)
            {
                x = 1;
            }
        }
    }

}