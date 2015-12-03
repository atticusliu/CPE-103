/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 20 November 2015
 * Project 5
 */

/*This file contains 5 sorting methods - 3 of which are O(N^2) routines and 2 of which are O(NlogN) routines */

import java.util.*;

// public class to hold all five sorting algorithms, in addition to private helper functions
public class Sorts {

    //selection sort method
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr, int size)
    {
        // minINdex is a variable to hold i in the for loop
        int minIndex;
        // temp is a variable to help with the swap
        T temp;
        //go through list and find minimum value and swap it with list at position i
        for(int i = 0; i < size - 1; i++)
        {
            minIndex = i;
            //comparing with next element
            for (int j = i+1; j < size; j++)
            {
                //if the element at j is less than the element at the minimum index then set the new minimum index to j
                if (arr[j].compareTo(arr[minIndex]) < 0)
                {
                    minIndex = j;
                }
            }
            // swap minIndex element with i element
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    //bubble sort method
    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr, int size)
    {
        //this variable is used to determine if the list needs another pass
        boolean done = false;
        //temp is a variable to help with the swap
        T temp;
        while(done == false)
        {
            //put the "flag" (done) down - means the list has been looked at
            done = true;
            //take every element and compare it to its right neighbor - one iteration compares each pair
            for(int i = 0; i < size-1; i++)
            {
                if(arr[i].compareTo(arr[i+1]) > 0)
                {
                    // swap elements
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    // indicates need for another scan
                    done = false;
                }
            }
        }
    }

    //insertion sort method
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int size)
    {
        //temp variable is to help with swap
        T temp;
        //represents the index of where the number should be placed in the list
        int j;
        //go through list and swap elements so that the elements arr[0,i] are sorted
        for(int i = 0; i < size; i++)
        {
            // move arr[i] left to its proper position in the segment arr[0..i]
            // save arr[i] value
            temp = arr[i];
            // starting with the i position then moving to the left
            j = i;
            // while j is not the leftmost position and j-1 element is greater than temp
            while(j != 0 && arr[j-1].compareTo(temp) > 0)
            {
                arr[j] = arr[j-1];
                j--;
            }
            // once j stops moving, temp value is put into the j spot
            arr[j] = temp;
        }
    }

    //merge sort method - cut list into halves and sort each half separately then merge the two sorted halves into 1 sorted list
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int size)
    {
        mergeSort(arr, 0, size-1);
    }

    //recursion method that sorts each half
    private static <T extends Comparable<? super T>> void mergeSort(T[] arr, int first, int last)
    {
        int middle;
        // if there are more than one elements in list[first..last] segment
        if(first < last)
        {
            //set middle to center position of the segment
            middle = (first + last) / 2;
            //recursive call for first half
            mergeSort(arr, first, middle);
            //recursive call for second half
            mergeSort(arr, middle+1, last);
            //merge the two sorted halves
            mergeSortedHalves(arr, first, middle, last);
        }
    }

    //merges the two sorted halves of the array segment arr[left,right]
    private static <T extends Comparable<? super T>> void mergeSortedHalves(T[] arr, int left, int middle, int right)
    {
        //temp is a temporary array of length right-left+1
        T[] temp = (T[]) new Comparable[right-left+1];
        // index1 is left index
        int index1 = left;
        // index2 is middle+1 index
        int index2 = middle+1;
        // index is beginning of temp array
        int index = 0;
        // while there are elements in both halves
        while(index1 <= middle && index2 <= right)
        {
            if(arr[index1].compareTo(arr[index2]) < 0)
            {
                temp[index] = arr[index1];
                index1++;
            }
            else
            {
                temp[index] = arr[index2];
                index2++;
            }
            index++;
        }
        // if there are elements in the first half
        if(index1 <= middle)
        {
            // copy all remaining elements of the first half into temp array
            for(int i = index1; i <= middle; i++)
            {
                temp[index] = arr[i];
                index++;
            }
        }
        else
        {
            // copy all remaining elements of the second half into the temp array
            for(int i = index2; i <= right; i++)
            {
                temp[index] = arr[i];
                index++;
            }
        }
        // copy elements from temp[0..temp.length-1] back into arr[left..right]
        for(int i = 0; i < temp.length; i++)
        {
            arr[left+i] = temp[i];
        }
    }

    //quick sort method - select pivot and split list and then order them
    public static <T extends Comparable<? super T>> void quickSort(T[] arr, int size)
    {
        quickSort(arr, 0, size-1);
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] list, int first, int last)
    {
        int pivotIndex;
        // if there are more than one elements in list[first..last] segment
        if(first < last)
        {
            //select a pivot and put it at the end
            setPivotToEnd(list, first, last);
            //set the pivotIndex
            pivotIndex = splitList(list, first, last);
            //recursive call to sort the first sublist
            quickSort(list, first, (pivotIndex-1));
            //recursive call to sort the second sublist
            quickSort(list, (pivotIndex+1), last);
        }
    }

    //this method chooses the pivot value and places it as the last element of the list
    // guarantees that the pivot value is the last element in the array portion
    private static <T extends Comparable<? super T>> void setPivotToEnd(T[] arr, int left, int right)
    {
        // center index
        int center = (left+right) / 2;
        // temp is temporary variable to help with the swap
        T temp;
        // if center is smaller than left, swap the two
        if(arr[center].compareTo(arr[left]) < 0)
        {
            temp = arr[center];
            arr[center] = arr[left];
            arr[left] = temp;
        }
        // if right is smaller than left, swap the two
        if(arr[right].compareTo(arr[left]) < 0)
        {
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
        // if center is smaller than right, swap the two
        if(arr[center].compareTo(arr[right]) < 0)
        {
            temp = arr[center];
            arr[center] = arr[right];
            arr[right] = temp;
        }
    }

    //this method rearranges the elements of the list segment - pivot value is preceeded by smaller values and followed by greater values
    private static <T extends Comparable<? super T>> int splitList(T[] arr, int left, int right)
    {
        //set to the first cell of the segment
        int indexL = left;
        //set to the cell immediately before the pivot
        int indexR = right-1;
        //set the pivot
        T pivot = arr[right];
        // temp is temporary variable to help with the swap
        T temp;

        // while the two indices don't "cross over"
        while(indexL <= indexR)
        {
            while(arr[indexL].compareTo(pivot) < 0)
            {
                indexL++;
            }
            while(indexL <= indexR && arr[indexR].compareTo(pivot) > 0)
            {
                indexR--;
            }

            if(indexL <= indexR)
            {
                // swap elements in indexL and indexR cells
                temp = arr[indexL];
                arr[indexL] = arr[indexR];
                arr[indexR] = temp;
                // increment indexL, decrement indexR
                indexL++;
                indexR--;
            }
        }
        // swap elements in indexL and the pivot, arr[right]
        temp = arr[indexL];
        arr[indexL] = arr[right];
        arr[right] = temp;
        return indexL;
    }
}