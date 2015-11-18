import java.util.*;
import java.io.*;

public class ArraySummer{

    public static int arraySum(int[] arr, int first)
    {
        if(first == arr.length -1)
        {
            return arr[first];
        }
        else
        {
            return arr[first] + arraySum(arr, first+1);
        }
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

        System.out.print("The sum of the array is: " + arraySum(intArray, 0));
        System.out.println();

    }

}

