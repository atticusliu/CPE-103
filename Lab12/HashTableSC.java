import java.util.*;
import java.util.LinkedList;

public class HashTableSC<T>
{
    private LinkedList<T>[] table;
    public HashTableSC(int tablesize)
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
}
