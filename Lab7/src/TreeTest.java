import java.util.*;

public class TreeTest
{
    public static void main(String[] args)
    {
        Integer[] heapArray = new Integer[20];
        String[] tempArray = new String[20];
        Scanner sc = new Scanner(System.in);

        System.out.print("Input: " );
        String input = sc.nextLine();
        System.out.println();


        tempArray = input.split("\\s+");

        int count = 0;
        while(count < tempArray.length)
        {
            heapArray[count] = Integer.parseInt(tempArray[count]);
            count++;
        }

        /*
        System.out.println(heapArray[0]);
        System.out.println(heapArray[1]);
        System.out.println(heapArray[2]);
        System.out.println(heapArray[3]);
        System.out.println(heapArray[4]);
        System.out.println(heapArray[5]);
        */
        //System.out.println(tempArray.length);

        // for heaptest
        if(TreeWork.isHeap(heapArray, tempArray.length))
            System.out.println("Heaptest: IS a heap.");
        else
            System.out.println("Heaptest: is NOT a heap");
        TreeWork.printTree(heapArray, tempArray.length);
    }
}