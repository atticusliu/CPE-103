/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 20 November 2015
 * Project 5
 */

/* This file runs the Sorts methods on a REVERSE-sorted list of integers*/

import java.util.*;

// class to obtain sort times for reverse-sorted list of integers
public class SortTimes2
{
    // main function where everything takes place
    public static void main(String[] args)
    {
        //5 arrays of 80,000 integer elements
        Integer[] array1 = new Integer[80000];
        Integer[] array2 = new Integer[80000];
        Integer[] array3 = new Integer[80000];
        Integer[] array4 = new Integer[80000];
        Integer[] array5 = new Integer[80000];

        System.out.println("TEST2: reverse sorted list");
        System.out.println();

        // set N to 5000, our starting value
        int N = 5000;
        // create 4 more copies of a reverse-sorted list
        while(N <= 80000)
        {
            for (int j =0; j < N; j++)
            {
                array1[j] = N-j;
                array2[j] = N-j;
                array3[j] = N-j;
                array4[j] = N-j;
                array5[j] = N-j;
            }
            // SELECTION SORT
            // start time for SS
            long startTimeSS = System.nanoTime();
            Sorts.selectionSort(array1, N);
            // end time for SS
            long endTimeSS = System.nanoTime();
            // calculated result time for SS
            long resultSS = (endTimeSS - startTimeSS) / 1000000;

            // BUBBLE SORT
            // start time for BS
            long startTimeBS = System.nanoTime();
            Sorts.bubbleSort(array2, N);
            // end time for BS
            long endTimeBS = System.nanoTime();
            // calculated result time for BS
            long resultBS = (endTimeBS - startTimeBS) / 1000000;

            // INSERTION SORT
            // start time for IS
            long startTimeIS = System.nanoTime();
            Sorts.insertionSort(array3, N);
            // end time for IS
            long endTimeIS = System.nanoTime();
            // calculated result time for IS
            long resultIS = (endTimeIS - startTimeIS) / 1000000;

            // MERGE SORT
            // start time for MS
            long startTimeMS = System.nanoTime();
            Sorts.mergeSort(array4, N);
            // end time for MS
            long endTimeMS = System.nanoTime();
            // calculated result time for MS
            long resultMS = (endTimeMS - startTimeMS) / 1000000;

            // QUICK SORT
            // start time for QS
            long startTimeQS = System.nanoTime();
            Sorts.quickSort(array5, N);
            // end time for QS
            long endTimeQS = System.nanoTime();
            // calculated result time for QS
            long resultQS = (endTimeQS - startTimeQS) / 1000000;

            System.out.println("N=" + N + ": T_ss=" + resultSS + ", T_bs=" + resultBS + ", T_is=" + resultIS + ", T_ms=" + resultMS + ", T_qs=" + resultQS);
            // double N
            N = N * 2;
        }
        System.out.println();
        System.out.println("END TEST2");
    }
}
