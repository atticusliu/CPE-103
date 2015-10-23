import java.lang.UnsupportedOperationException;
import java.util.*;
import java.util.NoSuchElementException;

public class LList<T>
{
    private Node head;

    private class Node
    {
        T component;
        Node next;
    }


    private class Iter implements Iterator<T>
    {
        public Node cursor;
        public Iter()
        {
            cursor = head;
        }
        public boolean hasNext()
        {
            return cursor != null;
        }
        public T next()
        {
            if(!hasNext())
                throw new NoSuchElementException();
            T answer = cursor.component;
            cursor = cursor.next;
            return answer;
        }
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    //constructor
    public LList()
    {
        head = null;
    }

    //method 1
    public Iterator<T> iterator()
    {
        return new Iter();
    }

    //method 2
    public void add(T item)
    {
        Node temp = new Node();
        temp.component = item;
        if (head == null)
        {
            head.next = temp;
        }
        else
        {
            Node current = new Node();
            current = head;
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = temp;
        }

    }


}
