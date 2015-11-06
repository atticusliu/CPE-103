import java.util.Iterator;

/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 4 November 2015
 * Project 4
 */
public class HashTable
{
    //objects of this class are saved in the table
    private class HashEntry
    {
        //stores the element of the collection
        Object element;
        //represents if entry is active or not (true - active; false - inactive)
        boolean active;

    }
    //data members
    //holds the entries of the table
    private HashEntry[] table;
    //holds the number of occupied cells in the table (active and inactive)
    private int numCells;

    //constructor creates an empty hash table and takes one parameter that represents the number of elements in the collection
    public HashTable(int size)
    {
        table = new HashEntry[nextPrime(2*size)];
        numCells = 0;
    }

    //private Iter class that implements Iterator
    private class Iter implements Iterator
    {
        int cursor;
        public Iter()
        {
            cursor = 0;
        }



    }

    //create a method nextPrime that finds the next prime number
    pubic int nextPrime(int number)
    {

    }

    //methods of basic operations

    //inserts an element into hash table
    public void insert(Object item)
    {

    }

    //deletes specified item from table
    public void delete(Object item)
    {

    }

    //finds and retrieves given element
    public Object find(Object item)
    {

    }

    //returns the number of elements in the collection
    public int elementCount()
    {

    }

    //checks if colletion/table is empty or not
    public boolean isEmpty()
    {

    }

    //clears contents of collection/table
    public void makeEmpty()
    {

    }

    //prints table contents
    public void printTable()
    {

    }

    //creates an iter object for collection
    public Iterator iterator()
    {

    }

}