/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 20 November 2015
 * Project 5
 */

import java.util.*;

public class Sorts {

    public static <T extends Comparable<? super T>> void selectionSort(T[] arr, int size)
    {
        // minINdex is a variable to hold i in the for loop
        int minIndex;
        // temp is a variable to help with the swap
        T temp;
        for(int i = 0; i < size; i++)
        {
            minIndex = i;
            for (int j = i+1; j < size; j++)
            {
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

    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr, int size)
    {
        boolean done = false;
        T temp;
        while(done == false)
        {
            done = true;
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

    public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int size)
    {
        T temp;
        int j;
        for(int i = 1; i < size; i++)
        {
            // move arr[i] left to its proper position in the segment arr[0..i]
            // save arr[i] value
            temp = arr[i];
            // starting with the i position then moving to the left
            j = i;
            // while j is not the leftmost position and j-1 element is greater than temp
            while(j != 1 && arr[j-1].compareTo(temp) > 0)
            {
                arr[j] = arr[j-1];
                j--;
            }
            // once j stops moving, temp value is put into the j spot
            arr[j] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int size)
    {
        mergeSort(arr, 0, size-1);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] arr, int first, int last)
    {
        int middle;
        // if there are more than one elements in list[first..last] segment
        if(first < last)
        {
            middle = (first + last) / 2;
            mergeSort(arr, first, middle);
            mergeSort(arr, middle+1, last);
            mergeSortedHalves(arr, first, middle, last);
        }
    }

    private static <T extends Comparable<? super T>> void mergeSortedHalves(T[] arr, int left, int middle, int right)
    {
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
            setPivotToEnd(list, first, last);
            pivotIndex = splitList(list, first, last);
            quickSort(list, first, (pivotIndex-1));
            quickSort(list, (pivotIndex+1), last);
        }
    }

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
            arr[right] = arr[center];
        }
    }

    private static <T extends Comparable<? super T>> int splitList(T[] arr, int left, int right)
    {
        int indexL = left;
        int indexR = right-1;
        T pivot = arr[right];
        // temp is temporary variable to help with the swap
        T temp;

        // while the two indices don't "cross over"
        while(indexL <= indexR)
        {
            while(arr[indexL].compareTo(pivot) < 0)
                indexL++;
            while(left <= right && arr[indexR].compareTo(pivot) > 0)
                indexR--;
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
            // swap elements in indexL and right
            temp = arr[indexL];
            arr[indexL] = arr[right];
            arr[right] = temp;
        }
        return indexL;
    }
}