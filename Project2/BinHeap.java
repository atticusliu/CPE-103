/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 19 October 2015
 * Project 2
 */

import java.lang.Comparable;
import java.util.*;

// class that defines the generic BinHeap data structure
public class BinHeap <T extends Comparable<? super T>>
{
    // declaring array that will be heap
    private T arr[];
    // declaring size integer
    private int size;

    // static class to define MyException
    public static class MyException extends RuntimeException
    {
        // constructor without parameters
        public MyException()
        { super(); }

        // constructor with parameter message
        public MyException(String message)
        { super(message); }
    }

    // constructor for BinHeap without parameters
    public BinHeap()
    {
        // allocate heap to hold 100 items
        arr = (T[]) new Comparable[100];
        // set size of heap to 0
        size = 0;
    }

    // constructor for BinHeap with parameter that defines maxSize
    public BinHeap(int maxSize)
    {
        // allocate heap to hold maxSize elements
        arr = (T[]) new Comparable[maxSize];
        // set size of heap to 0
        size = 0;
    }

    // Method for inserting an item into heap
    public void insert(T item)
    {
        // below is the resizing function
        if(size == arr.length -1)
        {
            // declaring new array arr1
            T[] arr1;
            // arr1 will be twice as long as arr
            arr1 = (T[]) new Comparable[arr.length*2];
            // mapping to arr1
            // c is a counter
            int c = 0;
            while( c < arr.length)
            {
                // map what's in arr at index c to arr1 at index c
                arr1[c] = arr[c];
                // increment c
                c++;
            }
            // the new resized array arr1 will replace old, smaller array arr
            arr = arr1;
        }
        // insert method below
        // set hole to be first "free" cell in array
        int hole = size;
        // creating holeParent with equation specified below
        int holeParent = (hole-1)/2;
        // while hole is not the root AND hole's parent's value is greater than item
        while(hole != 0 && arr[holeParent].compareTo(item) > 0)
        {
            // copy hole's parent's value into hole location
            arr[hole] = arr[holeParent];
            // set hole to "point" to its parent
            hole = holeParent;
            holeParent = (hole-1)/2;
        }
        // put item into hole
        arr[hole] = item;
        // incrememnt size of array
        size++;
    }

    // Method that deletes the minimum element from a heap
    public T deleteMin()
    {
        // to handle empty excpetion
        if(size == 0)
        {
            throw new MyException("Heap is empty.");
        }

        // create int hole, set to 0
        int hole = 0;
        // create return value as the item at index hole
        T returnValue = arr[hole];
        // create item to be last item of heap
        T item = arr[size-1];
        // decrement size
        size--;
        // call newHole() method to get newhole
        int newhole = newHole(hole, item);
        while(newhole != -1)
        {
            // set value of arr[newhole] to be arr[hole]
            arr[hole] = arr[newhole];
            // hole is now whatever newhole was
            hole = newhole;
            // update newhole by calling newHole()
            newhole = newHole(hole, item);
        }
        // put item where the hole is in the heap
        arr[hole] = item;
        return returnValue;
    }

    // Method that returns boolean value for if heap is empty or otherwise
    public boolean isEmpty()
    {
       return size == 0;
    }

    // Method that returns size of heap
    public int size()
    {
        return size;
    }

    // Method that returns the heap as a whole string
    public String toString()
    {
        // create a counter called count
        int count = 0;
        // create empty string for concatenation purposes
        String retString = "";
        while(count < size)
        {
            // appending to retString
            retString += arr[count] + " ";
            // increment count
            count++;
        }
        return retString;
    }

    // Private method called on in delete method
    private int newHole(int hole, T item)
    {
        // initially set returnIndex to -1
        int returnIndex = -1;
        // leftChildIndex set to where left child should be
        int leftChildIndex = 2*hole + 1;
        // rightChildIndex set to where right child should be
        int rightChildIndex = 2*hole + 2;

        // if left child's index is a valid index in heap
        if(leftChildIndex < size)
        {
            // if there is NO right child
            if(rightChildIndex > size)
            {
                // if left child is smaller than item
                if(arr[leftChildIndex].compareTo(item) < 0)
                {
                    // set return Index to point to left child
                    returnIndex = leftChildIndex;
                }
            }
            // if hole has both children
            else
            {
                // find smaller child
                // if left child is smaller than right child
                if(arr[leftChildIndex].compareTo(arr[rightChildIndex]) < 0)
                {
                    // if left child is less than item
                    if(arr[leftChildIndex].compareTo(item) < 0)
                    {
                        // set returnIndex to point to left child
                        returnIndex = leftChildIndex;
                    }
                }
                // if right child is smaller
                else
                {
                    // if right child is less than item
                    if(arr[rightChildIndex].compareTo(item) < 0)
                    {
                        // set returnIndex to right child
                        returnIndex = rightChildIndex;
                    }
                }
            }
        }
        return returnIndex;
    }
}