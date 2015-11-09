public class RunTimes{

    public static void main(String[] args)
    {

        System.out.println("Logarithmic algorithm's running times: ");
        long N = 10000;
        while(N < 100000000)
        {
            long startTime = System.nanoTime();
            Algorithms.logarithmicAlgorithm(N);
            long endTime = System.nanoTime();
            System.out.println("T(" + N + ") = " + ((endTime - startTime) / 1000000));
            N = N * 2;
        }

        System.out.println();
        System.out.println("Linear algorithm's running times: ");
        N = 10000;
        while(N < 100000000)
        {
            long startTime = System.nanoTime();
            Algorithms.linearAlgorithm(N);
            long endTime = System.nanoTime();
            System.out.println("T(" + N + ") = " + ((endTime - startTime) / 1000000));
            N = N * 2;
        }

        System.out.println();
        System.out.println("NlogN algorithm's running times: ");
        N = 10000;
        while(N < 100000000)
        {
            long startTime = System.nanoTime();
            Algorithms.NlogNAlgorithm(N);
            long endTime = System.nanoTime();
            System.out.println("T(" + N + ") = " + ((endTime - startTime) / 1000000));
            N = N * 2;
        }

        System.out.println();
        System.out.println("Quadratic algorithm's running times: ");
        N = 10000;
        while(N < 800000)
        {
            long startTime = System.nanoTime();
            Algorithms.quadraticAlgorithm(N);
            long endTime = System.nanoTime();
            System.out.println("T(" + N + ") = " + ((endTime - startTime) / 1000000));
            N = N * 2;
        }
    }
}