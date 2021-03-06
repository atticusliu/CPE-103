import java.util.*;

public class LittleTester {

    public static void main(String[] args)
    {
        Random r = new Random();

        Integer[] array1 = new Integer[40000];
        Integer[] array2 = new Integer[40000];
        Integer[] array3 = new Integer[40000];
        Integer[] array4 = new Integer[40000];
        Integer[] array5 = new Integer[40000];

        int N = 40000;

        //for(int i = 3999; i >= 0; i--)
        for(int i = 40000-1; i >= 0; i--)
        {

            // RANDOM NUMBERS
            /*
            array1[i] = r.nextInt(N-1);
            array2[i] = r.nextInt(N-1);
            array3[i] = r.nextInt(N-1);
            array4[i] = r.nextInt(N-1);
            array5[i] = r.nextInt(N-1);
            */

            array1[i] = i;
            array2[i] = i;
            array3[i] = i;
            array4[i] = i;
            array5[i] = i;

        }

        Sorts.selectionSort(array1, 40);
        System.out.println("SELECTION SORT");
        for(int j = 0; j < 40; j++)
        {
            System.out.println(array1[j]);
        }

        Sorts.bubbleSort(array2, 40);
        System.out.println("BUBBLE SORT");
        for(int k = 0; k < 40; k++)
        {
            System.out.println(array2[k]);
        }

        Sorts.insertionSort(array3, 40);
        System.out.println("INSERTION SORT");
        for(int a = 0; a < 40; a++)
        {
            System.out.println(array3[a]);
        }

        Sorts.mergeSort(array4, 40);
        System.out.println("MERGE SORT");
        for(int b = 0; b < 40; b++)
        {
            System.out.println(array4[b]);
        }

        Sorts.quickSort(array5, 40);
        System.out.println("QUICK SORT");
        for(int c = 0; c < 40; c++)
        {
            System.out.println(array5[c]);
        }


    }
}
