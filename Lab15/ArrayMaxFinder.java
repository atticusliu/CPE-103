import java.util.*;
import java.io.*;

public class ArrayMaxFinder {

    public static int arrayMax(int[] arr, int first)
    {
        int max;
        if(first == arr.length -1)
        {
            max = first;
        }
        else
        {
            max = arrayMax(arr, first+1);
            if(arr[first] > arr[max])
            {
                max = first;
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] intArray = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 10 integers: ");
        for(int i = 0; i < 10; i++)
        {
            intArray[i] = sc.nextInt();
        }
        sc.nextLine();

        System.out.print("The max value of the array is: " + intArray[arrayMax(intArray, 0)]);
        System.out.println();

    }
}