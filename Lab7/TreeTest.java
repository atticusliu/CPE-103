import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.Integer;
import java.lang.NumberFormatException;
import java.util.*;

public class TreeTest
{
    public static void main(String[] args)
    {
        Integer[] heapArray = new Integer[20];
        String[] tempArray = new String[20];
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.print("Input: " );
        while(count < 20 && sc.hasNext()) {
            heapArray[count] = sc.nextInt();
            count++;
        }

        if(count == 0)
        {
            System.out.println();
            System.out.println("The tree is empty.");
        }
        else {
            if (TreeWork.isHeap(heapArray, count))
            {
                System.out.println("IS a heap.");
            }
            else
            {
                System.out.println("Is NOT a heap.");
            }
            TreeWork.printTree(heapArray, count);
        }
    }
}