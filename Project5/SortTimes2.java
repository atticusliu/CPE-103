/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 20 November 2015
 * Project 5
 */

import java.util.*;

public class SortTimes2
{
    public static void main(String[] args)
    {
        Integer[] array1 = new Integer[80000];
        Integer[] array2 = new Integer[80000];
        Integer[] array3 = new Integer[80000];
        Integer[] array4 = new Integer[80000];
        Integer[] array5 = new Integer[80000];

        System.out.println("TEST2: reverse sorted list");

        int N = 5000;
        while(N <= 80000)
        {
            for (int j = N - 1; j >= 0; j--)
            {
                array1[j] = j;
                array2[j] = j;
                array3[j] = j;
                array4[j] = j;
                array5[j] = j;
            }
            // SELECTION SORT
            long startTimeSS = System.nanoTime();
            Sorts.selectionSort(array1, N);
            long endTimeSS = System.nanoTime();
            long resultSS = (endTimeSS - startTimeSS) / 1000000;

            // BUBBLE SORT
            long startTimeBS = System.nanoTime();
            Sorts.bubbleSort(array2, N);
            long endTimeBS = System.nanoTime();
            long resultBS = (endTimeBS - startTimeBS) / 1000000;

            // INSERTION SORT
            long startTimeIS = System.nanoTime();
            Sorts.insertionSort(array3, N);
            long endTimeIS = System.nanoTime();
            long resultIS = (endTimeIS - startTimeIS) / 1000000;

            // MERGE SORT
            long startTimeMS = System.nanoTime();
            Sorts.mergeSort(array4, N);
            long endTimeMS = System.nanoTime();
            long resultMS = (endTimeMS - startTimeMS) / 1000000;

            // QUICK SORT
            long startTimeQS = System.nanoTime();
            Sorts.quickSort(array5, N);
            long endTimeQS = System.nanoTime();
            long resultQS = (endTimeQS - startTimeQS) / 1000000;

            System.out.println("N=" + N + ": T_ss=" + resultSS + ", T_bs=" + resultBS + ", T_is=" + resultIS + ", T_ms=" + resultMS + ", T_qs=" + resultQS);
            N = N * 2;
        }
        System.out.println("END TEST2");
    }
}
