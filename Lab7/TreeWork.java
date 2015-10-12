import java.util.*;

public class TreeWork<T extends Comparable<? super T>>
{

    public static <T extends Comparable<? super T>> boolean isHeap(T[] arr, int N)
    {
        // default value is true
        boolean ret = true;

        // compare leading value (1 out of (0, 1))
        for(int i = 0; i < (N/2) - 1; i++)
        {
            int parent = (i - 1) / 2;
            int leftChild = (2 * i) + 1;
            int rightChild = (2 * i) + 2;

            // prove if ret should be false
            if(parent.compareTo(leftChild) > 0)
            {
                ret = false;
            }
            // check if there's a right child
            // if not, just skip it
            if(rightChild <= N - 1)
            {
                if(parent.compareTo(rightChild) > 0))
                {
                    ret = false;
                }
            }
            return ret;
        }
    }

    public static <T> void printTree(T[] arr, int N)
    {

    }

}