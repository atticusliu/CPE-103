/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 19 October 2015
 * Project 2
 */

import java.lang.Comparable;
import java.util.*;

public class BinHeap <T extends Comparable<? super T>>
{
    private T arr[];
    private int size;

    public static class MyException extends RuntimeException
    {
        public MyException()
        { super(); }

        public MyException(String message)
        { super(message); }
    }

    // two constructors, one without parameters, one with a parameter
    public BinHeap()
    {
        arr = (T[]) new Comparable[100];
        size = 0;
    }

    public BinHeap(int maxSize)
    {
        arr = (T[]) new Comparable[maxSize];
        size = 0;
    }


    public void insert(T item)
    {
        // check space in array
        if(size < arr.length)
        {
            insertMethod(item);
        }
        else
        {
            // resize
            T[] arr1;
            arr1 = (T[]) new Comparable[arr.length*2];
            // mapping to arr1
            int c = 0;
            while( c < arr.length)
            {
                arr1[c] = arr[c];
                c++;
            }
            arr = arr1;
            insertMethod(item);
        }
    }

    // does actual insert for when resizing isn't and is necessary
    private void insertMethod(T item)
    {
        int hole = size;
        int holeParent = (hole-1)/2;
        // while hole is not the root AND hole's parent's value is greater than item
        while(hole != 0 && arr[holeParent].compareTo(item) > 0)
        {
            // copy hole's parent's value into hole location
            arr[hole] = arr[holeParent];
            // set hole to "point" to its parent
            hole = holeParent;
        }
        arr[hole] = item;
        size++;
    }

    public T deleteMin()
    {

    }

    public boolean isEmpty()
    {
        if(size == 0)
            return true;
        else
            return false;
    }

    public int size()
    {
        return size;
    }

    public String toString()
    {

    }
}