import java.util.*;

public class TreeWork<T extends Comparable<? super T>>
{

    public static <T extends Comparable<? super T>> boolean isHeap(T[] arr, int N)
    {
        // default value is true
        boolean ret = true;
        int lastParent = (N/2) - 1;
        int secondToLast = N - 2;
        int lastChild = N - 1;

        if(N == 1)
        {
            return true;
        }
        else if(N <= 3)
        {
            lastParent = 0;
            if(arr[lastChild].compareTo(arr[lastParent]) < 0)
            {
                ret = false;
            }
            if(arr[secondToLast].compareTo(arr[lastParent]) < 0)
            {
                ret = false;
            }
        }

        lastParent = (N/2) - 1;

        // compare leading value (1 out of (0, 1))
        for(int i = 0; i < lastParent + 1; i++) {
            //System.out.println(i);
            // the parent is i
            Integer leftChild = (2 * i) + 1;
            Integer rightChild = (2 * i) + 2;

            // prove if ret should be false
            // if parent is NOT greater or equal to value of children

            if (arr[leftChild].compareTo(arr[i]) < 0) {
                ret = false;
            }

            // check if there's a right child
            if (N % 2 == 1) {
                if (arr[rightChild].compareTo(arr[i]) < 0) {
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