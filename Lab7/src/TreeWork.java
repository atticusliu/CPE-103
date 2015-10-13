import java.util.*;

public class TreeWork<T extends Comparable<? super T>>
{

    public static <T extends Comparable<? super T>> boolean isHeap(T[] arr, int N)
    {
        // default value is true
        boolean ret = true;

        // compare leading value (1 out of (0, 1))
        for(int i = 0; i < Math.floor(Math.log(N) / Math.log(2)); i++)
        {
            // parent doesn't advance to next nodes b/c math

            Integer parent = (i - 1) / 2;
            //Integer parent = (i / 2) - 1;
            Integer leftChild = (2 * i) + 1;
            Integer rightChild = (2 * i) + 2;

            System.out.println("Parent: " + arr[parent]);
            System.out.println("leftChild: " + arr[leftChild]);
            System.out.println("rightChild: " + arr[rightChild]);

            // prove if ret should be false
            if(arr[parent].compareTo(arr[leftChild]) > 0)
            {
                ret = false;
            }
            // check if there's a right child
            // if not, just skip it
            if(rightChild <= N - 1)
            {
                if(arr[parent].compareTo(arr[rightChild]) > 0)
                {
                    ret = false;
                }
            }

        }
        return ret;
    }

    public static <T> void printTree(T[] arr, int N)
    {
        //System.out.println(arr[0]);

        for(int i = 0; i < N; i++)
        {
            System.out.print(arr[i] + "   ");
            double newLine = (double) Math.log(i) / Math.log(2.0);

            if(i == 0 || i == 2 || i == 6 || i == 14 || i == 31)
            {
                System.out.println();
            }
        }
        System.out.println();
    }

}