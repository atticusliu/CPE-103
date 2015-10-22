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


    //SOMETHING'S WRONG WITH THE WHILE LOOP WHEN WE ADD THE FOURTH ELEMENT
    public void insert(T item)
    {
        // resize
        if(size == arr.length -1)
        {
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
        }
        // insert method below
        int hole = size;
        int holeParent = (hole-1)/2;
        // while hole is not the root AND hole's parent's value is greater than item
        while(hole != 0 && item.compareTo(arr[holeParent]) < 0)
        {
            // copy hole's parent's value into hole location
            arr[hole] = arr[holeParent];
            // set hole to "point" to its parent
            hole = holeParent;
            System.out.println("HI");
        }
        arr[hole] = item;
        size++;
    }

    public T deleteMin()
    {
        if(size == 0)
        {
            throw new MyException("Heap is empty.");
        }

        int hole = 0;
        T returnValue = arr[hole];
        T item = arr[size-1];
        size--;
        int newhole = newHole(hole, item);
        while(newhole != -1)
        {
            arr[hole] = arr[newhole];
            hole = newhole;
            newhole = newHole(hole, item);
        }
        arr[hole] = item;
        return returnValue;
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
        int count = 0;
        String retString = "";
        while(count < size)
        {
            retString += arr[count] + " ";
            count++;
        }
        return retString;
    }

    private int newHole(int hole, T item)
    {
        int returnIndex = -1;
        int leftChildIndex = 2*hole + 1;
        int rightChildIndex = 2*hole + 2;

        if(leftChildIndex < size)
        {
            // if there is NO right child
            if(rightChildIndex != size - 1)
            {
                if(item.compareTo(arr[leftChildIndex]) >= 0)
                {
                    returnIndex = leftChildIndex;
                }
            }
            // if hole has both children
            else
            {
                // find smaller child
                if(arr[rightChildIndex].compareTo(arr[leftChildIndex]) < 0)
                {
                    // IS THIS COMPARISON CORRECT?
                    if(item.compareTo(arr[leftChildIndex]) < 0)
                    {
                        returnIndex = leftChildIndex;
                    }
                }
                else
                {
                    // IS THIS COMPARISON CORRECT?
                    if(item.compareTo(arr[rightChildIndex]) < 0)
                    {
                        returnIndex = rightChildIndex;
                    }
                }
            }
        }
        //System.out.println("returnIndex: " + returnIndex);
        return returnIndex;
    }
}