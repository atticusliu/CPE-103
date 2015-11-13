import java.util.*;

/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 4 November 2015
 * Project 4
 */

import java.util.*;

// HashTable class that includes private classes of HashEntry and Iter
// Also contains methods that act on the hash table
public class HashTable
{
    // private HashEntry class that defines the element and isActive components
    private class HashEntry
    {
        //stores the element of the collection
        public Object element;
        //represents if entry is active or not (true - active; false - inactive)
        public boolean isActive;

        //constructor
        public HashEntry(Object item)
        {
            // set element to item that was passed in as a parameter
            element = item;
            // tentatively set isActive to true
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
        // initialize table to be the prime number next up from twice the size specified
        table = new HashEntry[nextPrime(2*size)];
        occupiedCells = 0;
    }

    //hash function
    private int hash(Object item)
    {
        return  Math.abs(item.hashCode()) % table.length;
    }

    //private Iter class that implements Iterator
    private class Iter implements Iterator
    {
        int cursor;
        public Iter()
        {
            cursor = 0;

            // find first active element
            for(; cursor < table.length; cursor++)
            {
                if(table[cursor] != null && table[cursor].isActive)
                {
                    break;
                }
            }
        }

        public boolean hasNext()
        {
            return cursor < table.length;
        }

        public Object next()
        {
            if(!hasNext())
                throw new NoSuchElementException();
            // create temporary object called temp to hold table[cursor].element
            // we will return this at the end
            Object temp = table[cursor].element;
            // increment cursor to move on to the next element, if such an element exists
            cursor++;
            // find next active element using same logic used in Iter's constructor
            for(; cursor < table.length; cursor++)
            {
                if(table[cursor] != null && table[cursor].isActive)
                {
                    break;
                }
            }
            return temp;
        }

        // public remove method for the pre-order traversal
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    //create a method nextPrime that finds the next prime number
    private static int nextPrime(int number)
    {
        // move up
        // create int called nextPrimeNumber that, for the time being, holds the number+1 to move on
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
    private static boolean isPrime(int number)
    {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    //***** METHODS OF BASIC OPERATIONS BELOW *****

    //inserts an element into hash table
    public void insert(Object item)
    {
        // get an index using findPosition()
        int index = findPosition(item);
        if (table[index] == null)
        {
            // create a new HashEntry with item stored in it
            HashEntry newEntry = new HashEntry(item);
            // put the new entry into where index is, increment the number of occupied cells
            table[index] = newEntry;
            occupiedCells++;
            if (!(occupiedCells < (table.length/2)))
            {
                rehash();
            }
        }
        else
        {
            // if the entry isn't active already, make it active
            if (!table[index].isActive)
            {
                table[index].isActive = true;
            }
        }
    }

    //deletes specified item from table
    public void delete(Object item)
    {
        // get an index using findPosition()
        int index = findPosition(item);
        // make the HashEntry inactive if it exists
        if (table[index] != null && table[index].isActive)
        {
            table[index].isActive = false;
        }
    }

    //finds and retrieves given element
    public Object find(Object item)
    {
        // declare an Object called answer
        Object answer;
        // get an index using findPosition()
        int index = findPosition(item);
        // if the HashEntry exists, set it to answer
        // otherwise, make it null
        if (table[index] != null && table[index].isActive)
        {
            answer = table[index];
        }
        else
        {
            answer = null;
        }
        return answer;
    }

    //returns the number of elements in the collection
    public int elementCount()
    {
        // elemCount acts as a counter, starting with 0
        int elemCount = 0;
        // iterate through hash table, and if we come across a valid HashEntry, increment elemCount
        for (int i = 0; i < table.length; i++)
        {
            if (table[i] != null && table[i].isActive)
            {
                elemCount++;
            }
        }
        return elemCount;
    }

    //checks if collection/table is empty or not
    public boolean isEmpty()
    {
        // set a boolean variable called empty to true to begin with
        boolean empty = true;
        // iterate through hash table. If we find a valid HashEntry, we set empty to false, and break out of the loop
        // this means that the table isn't empty
        for (int i = 0; i < table.length; i++)
        {
            if (table[i] != null && table[i].isActive) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    //clears contents of collection/table
    public void makeEmpty()
    {
        // create a new HashEntry[], set it equal to table
        table = new HashEntry[table.length];
    }

    //prints table contents
    public void printTable()
    {
        // iterate through the hash table
        // if it's null, say it's empty. If it's active, say it's active. Otherwise, it's inactive
        for (int i = 0; i < table.length; i++)
        {
            if(table[i] == null)
            {
                System.out.println("[" + i + "]: empty");
            }
            else if (table[i].isActive)
            {
                System.out.println("[" + i + "]: " + table[i].element + ", active");
            }
            else
            {
                System.out.println("[" + i + "]: " + table[i].element + ", inactive");
            }
        }
    }

    //creates an iter object for collection
    public Iterator iterator()
    {
        // return a new iterator object
        return new Iter();
    }

    // ***** PRIVATE METHODS BELOW *****

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
        while (table[index] != null && !(table[index].element.equals(item)))
        {
            i++;
            // index is computed using the equation in the line below:
            index = (hashValue + i * i) % table.length;
        }
        return index;
    }

    //help function for insert; creates a new table of prime size at least twice as large as the old array and inserts all active elements
    private void rehash()
    {
        // declare an integer index
        int index;
        // create a temporary array of HashEntries with table.length as its size
        HashEntry[] temp = new HashEntry[table.length];
        // copy contents of table into temp
        temp = table;
        // create a new table under the "table" variable, with the size being the next prime up from twice the length
        table = new HashEntry[nextPrime(2*temp.length)];
        occupiedCells = 0;
        // rehashing process below
        for (int i = 0; i < temp.length; i++)
        {
            if (temp[i] != null && temp[i].isActive)
            {
                index = findPosition(temp[i]);
                table[index] = temp[i];
                occupiedCells++;
            }
        }
    }
}