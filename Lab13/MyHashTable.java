import java.util.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyHashTable<T>
{
    private LinkedList<T>[] table;

    private class Iter implements Iterator<T>
    {
        int i, j;
        // constructor
        public Iter()
        {
            for(int x = 0; x < table.length; x++)
            {
                if(table[x].size() != 0)
                    break;
                else
                    i++;
            }
        }

        // check if there is an unvisited element
        public boolean hasNext()
        {
            return i < table.length;
        }

        // return "next" element of the collection
        public T next()
        {
            T temp;
            if(!hasNext())
                throw new NoSuchElementException();
            else
            {
                temp = table[i].get(j);
                if(j != table[i].size()-1)
                {
                    j++;
                }
                else
                {
                    i++;
                    j = 0;
                    for(;i < table.length; i++) {
                        if(table[i].size() != 0)
                            break;
                    }
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

    public Iterator<T> iter()
    {
        return new Iter();
    }



    public MyHashTable(int tablesize)
    {
        table = (LinkedList<T>[]) new LinkedList[tablesize];
        for (int i = 0; i < table.length; i++)
        {
            table[i] = new LinkedList<T>();
        }
    }

    //methods
    public void insert(T item)
    {
        table[hash(item)].addFirst(item);
    }

    public void delete(T item)
    {
        if (table[hash(item)].contains(item))
            table[hash(item)].remove(item);
    }

    public boolean find(T item)
    {
        return table[hash(item)].contains(item);
    }

    private int hash(T item)
    {
        return Math.abs(item.hashCode()) % table.length;
    }

    public boolean isEmpty()
    {
        // true if the thing is empty
        for (int i = 0; i < table.length; i++)
        {
            if(table[i].size() != 0)
                return false;
            //System.out.println(ret);
        }
        return true;
    }

    public void print()
    {
        for(int i = 0; i < table.length; i++)
        {
            System.out.print(i + ":" + " ");
            for (int j = 0; j< table[i].size(); j++)
                System.out.print(table[i].get(j) + " ");
            System.out.println();
        }
    }

    public void makeEmpty()
    {
        for(int i = 0; i < table.length; i++)
            table[i].clear();
    }

    public int size()
    {
        int count = 0;
        for(int i = 0; i < table.length; i++)
            count += table[i].size();
        return count;
    }
}
