import java.util.Iterator;

/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 4 November 2015
 * Project 4
 */

import java.util.*;
import java.util.NoSuchElementException;

public class HashTable
{
    //objects of this class are saved in the table
    private class HashEntry
    {
        //stores the element of the collection
        Object element;
        //represents if entry is active or not (true - active; false - inactive)
        boolean isActive;

        //constructor
        public HashEntry(Object item)
        {
            element = item;
            isActive = true;

        }

    }
    //data members
    //holds the entries of the table
    private HashEntry[] table;
    //holds the number of occupied cells in the table (active and inactive)
    private int occupiedCells;

    //constructor creates an empty hash table and takes one parameter that represents the number of elements in the collection
    public HashTable(int size)
    {
        table = new HashEntry[nextPrime(2*size)];
        occupiedCells = 0;
    }

    //hash function
    private int hash(Object item)
    {
        return Math.abs(item.hashCode())% table.length;
    }

    //private Iter class that implements Iterator
    private class Iter implements Iterator<Object>
    {
        int cursor;
        public Iter()
        {
            cursor = 0;
        }

        public boolean hasNext()
        {
            return cursor < table.length;
        }

        public Object next()
        {
            if(!hasNext())
                throw new NoSuchElementException();
            return table[cursor++];
        }

        // public remove method for the pre-order traversal
        public void remove()
        {
            throw new UnsupportedOperationException();
        }

    }

    //create a method nextPrime that finds the next prime number
    public int nextPrime(int number)
    {
        // move up
        int nextPrimeNumber = number + 1;
        // start off at the number passed in as parameter
        if(number >= 2)
        {
            // if the nextPrimeNumber isn't prime, increment it, run it again until we get a new prime number
           while(!isPrime(nextPrimeNumber))
           {
               nextPrimeNumber++;
           }
        }
        return nextPrimeNumber;
    }

    // helper function for nextPrime that checks if the number is prime or not
    private boolean isPrime(int number)
    {
        int checker = 2;
        boolean isPrime = true;
        while(checker <= number)
        {
            // not a prime number
            if(number % checker == 0)
            {
                isPrime = false;
            }
            else
            {
                // increment checker
                checker++;
            }
        }
        return isPrime;
    }

    //methods of basic operations

    //inserts an element into hash table
    public void insert(Object item)
    {
        int index = findPosition(item);
        if (table[index] == null)
        {
            table[index].element = item;
            occupiedCells++;
            if (!(occupiedCells < (table.length/2)))
            {
                rehash();
            }
        }
        else
        {
            if (!table[index].isActive)
            {
                table[index].isActive = true;
            }
        }
    }

    //helper function for insert; finds and returns the location of where the entry/element should be placed in the table
    private int findPosition(Object item)
    {
        //i represents the sequential number of the probe
        int i = 0;
        //this is the original position that the item is hashed to
        int hashValue = hash(item);
        //index identifies the cell to be probed
        int index = hashValue;
        //keep looking for the correct position where the item should be hashed to
        while (table[index] != null && table[index].element != item)
        {
            i++;
            index = (hashValue + (i^2))% table.length;

        }
        return index;
    }

    //help function for insert; creates a new table of prime size at least twice as large as the old array and inserts all active elements
    private void rehash()
    {
        int index;
        HashEntry[] temp = new HashEntry[table.length];
        temp = table;
        table = new HashEntry[nextPrime(2*temp.length)];
        occupiedCells = 0;
        for (int i = 0; i <= temp.length; i++)
        {
            if (temp[i].element != null && temp[i].isActive)
            {
                index = findPosition(temp[i].element);
                table[index].element = temp[i].element;
                occupiedCells++;
            }
        }

    }

    //deletes specified item from table
    public void delete(Object item)
    {
        int index = findPosition(item);
        if (table[index] != null && table[index].isActive)
        {
            table[index].isActive = false;
        }
    }

    //finds and retrieves given element
    public Object find(Object item)
    {
        boolean answer;
        int index = findPosition(item);
        if (table[index] != null && table[index].isActive)
        {
            answer = true;
        }
        else
        {
            answer = false;
        }
        return answer;
    }

    //returns the number of elements in the collection
    public int elementCount()
    {
        int elemCount = 0;
        for (int i = 0; i<= table.length; i ++)
        {
            if (table[i].isActive)
                elemCount++;
        }
        return elemCount;
    }

    //checks if colletion/table is empty or not
    public boolean isEmpty()
    {
        boolean empty = true;
        for (int i = 0; i <= table.length; i++)
        {
            if (table[i].isActive) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    //clears contents of collection/table
    /*public void makeEmpty()
    {


    }
    */

    //prints table contents
    public void printTable()
    {
        for (int i = 0; i <= table.length; i++)
        {
            if (table[i].isActive)
            {
                System.out.println("[" + i + "]:   " + table[i].element + ", active");
            }
            else
                System.out.println("[" + i + "]:   " + table[i].element + ", inactive");
            //include an else if statement to show that it is empty
        }
    }

    //creates an iter object for collection
    public Iterator<Object> iterator()
    {
        return new Iter();
    }

}